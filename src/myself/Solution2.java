package myself;
//095
class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0||text2.length()==0){
            return 0;
        }
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length][chars2.length];
        dp[0][0] = chars1[0] == chars2[0] ? 1 : 0;
        for (int i = 1; i < chars2.length; i++) {
            dp[0][i] = (chars1[0] == chars2[i] ? 1 : dp[0][i - 1]);
        }
        for (int i = 1; i < chars1.length; i++) {
            dp[i][0] = (chars1[i] == chars2[0] ? 1 : dp[i - 1][0]);
        }
        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                int p3 = chars1[i] == chars2[j] ? 1 + dp[i - 1][j - 1] : 0;
                dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i - 1][j], p3));
            }
        }
        return dp[chars1.length - 1][chars2.length - 1];
//        return process(chars1,chars2,chars1.length-1,chars2.length-1);
    }
    //process为
//    public int process(char[] text1, char[] text2, int cur1, int cur2) {
//        if (cur1 == 0 && cur2 == 0) {
//            return text1[0] == text2[0] ? 1 : 0;
//        } else if (cur1 == 0) {
//            return text1[0] == text2[cur2] ? 1 : process(text1, text2, cur1, cur2 - 1);
//        } else if (cur2 == 0) {
//            return text1[cur1] == text2[cur2] ? 1 : process(text1, text2, cur1 - 1, cur2);
//        } else {
//            int res;
//            int p1 = process(text1, text2, cur1, cur2 - 1);
//            int p2 = process(text1, text2, cur1 - 1, cur2);
//            res = Math.max(p1, p2);
//            int p3 = text1[cur1] == text2[cur2] ? 1 + process(text1, text2, cur1 - 1, cur2 - 1) : 0;
//            res = Math.max(res, p3);
//            return res;
//        }
//    }
}