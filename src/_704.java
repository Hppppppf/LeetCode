public class _704 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(_704.search(nums,9));
        return;
    }
    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int mid = (i + j) / 2;
        while (i != mid && j != mid){
            if (target == nums[mid])    return mid;
            else if (target < nums[mid])    j = mid;
            else if (target > nums[mid])    i = mid;
            //mid = (i + j) / 2;
            mid = mid + (j - i) / 2;//防止溢出
        }
        if (nums[i] == target)  return i;
        else if (nums[j] == target) return j;
        else return -1;
    }
}
