package myself;

public class Solution19 {
     public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] prefix = new int[n];
            int[] posfix = new int[n];
            prefix[0] = 1;
            posfix[n - 1] = 1;
            for(int i = 1;i < n;i++){
                prefix[i] = prefix[i - 1]*nums[i - 1];
            }
            for(int i = n -  2;i >= 0;i--){
                posfix[i] = posfix[i + 1]*nums[i + 1];
            }
            int[] res = new int[n];
            for(int i = 0;i < n;i++){
                res[i] = prefix[i]*posfix[i];
            }
            return res;
     }
}
