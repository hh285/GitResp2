package myself;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Solution11 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        Integer[] array =ans.toArray(new Integer[ans.size()]);
        return ans;
    }
}
