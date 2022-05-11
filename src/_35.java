public class _35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(_35.searchInsert(nums,2));
        return;
    }
    public static int searchInsert(int[] nums, int target) {
        if (target < nums[0])   return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (target == nums[mid])  return mid;
            else if (target < nums[mid])   right = mid - 1;
            else if (target > nums[mid])  left = mid + 1;
            //System.out.println("mid"+mid);
        }
       if (target > nums[mid])  return mid+1;
       else return mid;
    }
}
