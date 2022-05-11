package class18;
//        给定一个整型数组arr，
//        代表数值不同的纸牌排成一条线玩家A和玩家B依次拿走每张纸牌规定玩家A先拿，
//        玩家B后拿但是每个玩家每次只能拿走最左或最右的纸牌
//        玩家A和玩家B都绝顶聪明请返回最后获胜者的分数
public class Code02_CardsInLine {
    public static int Win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int p1 = First1(arr, 0, arr.length - 1);
        int p2 = Second1(arr, 0, arr.length - 1);
        return Math.max(p1, p2);
    }
    // arr[L..R]，先手获得的最好分数返回
    public static int First1(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int r1 = arr[start] + Second1(arr, start + 1, end);
        int r2 = arr[end] + Second1(arr, start, end - 1);
        return Math.max(r1, r2);//取走最大的结果
    }
    // arr[L..R]，后手获得的最好分数返回
    public static int Second1(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        int r1 = First1(arr, start + 1, end);//对手拿走了start
        int r2 = First1(arr, start, end - 1);//对手拿走了end
        return Math.min(r1, r2);//因为后手两者小的，会被留下来，给前面那个人
    }

    public static int Win2(int[] arr) {//傻缓存
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N=arr.length;
        //start 0-len-1
        //end   0-len-1
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fmap[i][j] = -1;
                gmap[i][j] = -1;
            }
        }
        int p1 = First2(arr, 0, arr.length - 1,fmap);
        int p2 = Second2(arr, 0, arr.length - 1,gmap);
        return Math.max(p1, p2);
    }
    // arr[L..R]，先手获得的最好分数返回
    public static int First2(int[] arr, int start, int end,int[][] fmap) {
        if (fmap[start][end] != -1) {
            return fmap[start][end];
        }
        int ans=0;
        if (start == end) {
            ans = 0;
        }
        else{
            int r1 = arr[start] + Second1(arr, start + 1, end);
            int r2 = arr[end] + Second1(arr, start, end - 1);
            ans=Math.max(r1, r2);//取走最大的结果
        }
        fmap[start][end]=ans;
        return ans;
    }
    // arr[L..R]，后手获得的最好分数返回
    public static int Second2(int[] arr, int start, int end,int[][] gmap) {
        if (gmap[start][end] != -1) {
            return gmap[start][end];
        }
        int ans=0;
        if (start == end) {
            ans= arr[start];
        }
        else{
            int r1 = First2(arr, start + 1, end,gmap);//对手拿走了start
            int r2 = First2(arr, start, end - 1,gmap);//对手拿走了end
            ans= Math.min(r1, r2);//因为后手两者小的，会被留下来，给前面那个人
        }
        gmap[start][end]=ans;
        return ans;
    }

    public static int Win3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            fmap[i][i] = arr[i];
        }
        for (int col=1;col<N;col++){
            int row=0;
            int colum=col;
            while(colum<N){
                fmap[row][colum]=Math.max(arr[row]+gmap[row+1][colum],arr[colum]+gmap[row][colum-1]);
                gmap[row][colum]=Math.min(fmap[row+1][colum],fmap[row][colum-1]);
            }
        }
        return Math.max(fmap[0][N - 1], gmap[0][N - 1]);
    }

    //-----------------------myself--------------------------------

    // 根据规则，返回获胜者的分数
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int first = f1(arr, 0, arr.length - 1);
        int second = g1(arr, 0, arr.length - 1);
        return Math.max(first, second);
    }

    // arr[L..R]，先手获得的最好分数返回
    public static int f1(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int p1 = arr[L] + g1(arr, L + 1, R);
        int p2 = arr[R] + g1(arr, L, R - 1);
        return Math.max(p1, p2);
    }

    // arr[L..R]，后手获得的最好分数返回
    public static int g1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int p1 = f1(arr, L + 1, R); // 对手拿走了L位置的数
        int p2 = f1(arr, L, R - 1); // 对手拿走了R位置的数
        return Math.min(p1, p2);
    }

    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fmap[i][j] = -1;
                gmap[i][j] = -1;
            }
        }
        int first = f2(arr, 0, arr.length - 1, fmap, gmap);
        int second = g2(arr, 0, arr.length - 1, fmap, gmap);
        return Math.max(first, second);
    }

    // arr[L..R]，先手获得的最好分数返回
    public static int f2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (fmap[L][R] != -1) {
            return fmap[L][R];
        }
        int ans = 0;
        if (L == R) {
            ans = arr[L];
        } else {
            int p1 = arr[L] + g2(arr, L + 1, R, fmap, gmap);
            int p2 = arr[R] + g2(arr, L, R - 1, fmap, gmap);
            ans = Math.max(p1, p2);
        }
        fmap[L][R] = ans;
        return ans;
    }

    // // arr[L..R]，后手获得的最好分数返回
    public static int g2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (gmap[L][R] != -1) {
            return gmap[L][R];
        }
        int ans = 0;
        if (L != R) {
            int p1 = f2(arr, L + 1, R, fmap, gmap); // 对手拿走了L位置的数
            int p2 = f2(arr, L, R - 1, fmap, gmap); // 对手拿走了R位置的数
            ans = Math.min(p1, p2);
        }
        gmap[L][R] = ans;
        return ans;
    }

    public static int win3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            fmap[i][i] = arr[i];
        }
        for (int startCol = 1; startCol < N; startCol++) {
            int L = 0;
            int R = startCol;
            while (R < N) {
                fmap[L][R] = Math.max(arr[L] + gmap[L + 1][R], arr[R] + gmap[L][R - 1]);
                gmap[L][R] = Math.min(fmap[L + 1][R], fmap[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(fmap[0][N - 1], gmap[0][N - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7 };
        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));
        System.out.println(Win1(arr));
        System.out.println(Win2(arr));
        System.out.println(Win3(arr));
    }
}