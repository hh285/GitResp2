package class19;

public class Code01_Knapsack {
    // 所有的货，重量和价值，都在w和v数组里
    // 为了方便，其中没有负数
    // bag背包容量，不能超过这个载重
    // 返回：不超重的情况下，能够得到的最大价值
    public static int MaxValue1(int[] w, int[] v, int bag){
        if(w==null||v==null||w.length!=v.length||w.length==0||bag<0){
            return 0;//不合法参数
        }
        return Process1(w,v,0,bag);
    }
    public static int Process1(int[] w,int[] v,int cur,int rest){
        if(cur==w.length){
            return 0;
        }
        int p1=Process1(w,v,cur+1,rest);//不拿
        int p2=0;
        if(rest>=w[cur]){
            p2=Process1(w,v,cur+1,rest-w[cur])+v[cur];
        }
        return Math.max(p1,p2);
    }


    //cur  0到len
    //rest 0到bag
    public static int MaxValue2(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0 || bag < 0) {
            return 0;//不合法参数
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];//构建好dp表
        for (int cur = N - 1; cur >= 0; cur--) {//cur=w.length已经有了
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[cur + 1][rest];
                int p2 = 0;
                if (rest >= w[cur]) {
                    p2 = dp[cur + 1][rest - w[cur]] + v[cur];
                }
                dp[cur][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }
    //---------------------------myself----------------------------

    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        // 尝试函数！
        return process(w, v, 0, bag);
    }

    // index 0~N
    // rest 负~bag
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        int p1 = process(w, v, index + 1, rest);
        int p2 = 0;
        int next = process(w, v, index + 1, rest - w[index]);
        if (next != -1) {
            p2 = v[index] + next;
        }
        return Math.max(p1, p2);
    }

    public static int dp(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                if (next != -1) {
                    p2 = v[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 6, 7, 0, 2, 7 };
        int[] values = { 5, 6, 3, 19, 12, 4, 5 };
        int bag = 15;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(MaxValue1(weights, values, bag));
        System.out.println(MaxValue2(weights, values, bag));
        System.out.println(dp(weights, values, bag));
    }

}
