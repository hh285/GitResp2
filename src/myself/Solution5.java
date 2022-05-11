package myself;

public class Solution5 {
    public int MinPathSum(int[][] grid) {//左上到右下
        int process = process(grid, 0, 0);
        return process;
    }
    public int process(int[][] grid,int curx,int cury){
        if(curx<0||curx>grid.length-1||cury<0||cury>grid[0].length-1){
            return Integer.MAX_VALUE;
        }
        if(curx==grid.length-1&&cury==grid[0].length-1){
             return grid[curx][cury];
        }
        int p1 = process(grid, curx + 1, cury);
        int p2 = process(grid,curx,cury+1);
        return Math.min(p1,p2)+grid[curx][cury];
    }
//leetcode64
    public static int minPathSum(int[][] grid) {//左上到右下
        int[][] dp = new int[grid.length][grid[0].length];
        int row = grid.length;//行
        int col = grid[0].length;//列
        dp[row - 1][col - 1] = grid[row - 1][col - 1];
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = dp[i + 1][col - 1] + grid[i][col - 1];
        }
        for (int j = col - 2; j >= 0; j--) {
            dp[row - 1][j] = dp[row - 1][j + 1] + grid[row - 1][j];
        }
        for (int k = row - 2; k >= 0; k--) {
            for (int t = col - 2; t >= 0; t--) {
                int p1 = dp[k + 1][t];
                int p2 = dp[k][t + 1];
                dp[k][t] = Math.min(p1, p2) + grid[k][t];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0] = new int[]{1, 3, 1};
        grid[1] = new int[]{1, 5, 1};
        grid[2] = new int[]{4, 2, 1};
        int process = new Solution5().minPathSum(grid);
        System.out.println(process);
    }
}
