package myself;

public class Solution15 {
    public static int maxsum(int[] nums){
        int len=nums.length;
        int[] dp = new int[len];
        dp[0]=nums[0];
        for(int i=1;i<len;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,-2,3,10,-4,7,2,-5};
        int maxsum = new Solution15().maxsum(nums);
        System.out.println(maxsum);
    }
}
