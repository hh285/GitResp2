package myself;

public class search{
    public static int binarySearch2(int[] nums, int target) {
        if (null == nums || nums.length == 0) { return -1; }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid]==target){
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
        //return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,5,7,9,11,13,15};
        int res = binarySearch2(nums, 1);
        System.out.println(res);
        res = binarySearch2(nums, 3);
        System.out.println(res);
        res = binarySearch2(nums, 5);
    }
}