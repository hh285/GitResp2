package myself;

import java.util.HashSet;
import java.util.Set;

public class Solution13 {
        public int longestConsecutive(int[] nums) {
            int res = 0;
            Set<Integer> set = new HashSet<>();
            for(int a:nums){
                set.add(a);
            }
            for(int a:nums){
                if(set.contains(a-1)){
                    continue;
                }
                int temp = 0;
                while(set.contains(a)){
                    a++;
                    temp++;
                }
                res = Math.max(res,temp);
            }
            return res;
        }
}
