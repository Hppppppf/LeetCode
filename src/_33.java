/**
 * @author Hppppppf
 * @date 2022/5/2 17:36
 * @description https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class _33 {
    public static int search(int[] nums, int target) {
        //折半查找旋转点k；分两部分折半查找target
        int k = searchK(nums);
        return Math.max(search(nums, target, 0, k - 1), search(nums, target, k, nums.length - 1));
    }

    public static int searchK(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        int a = 0;
        if (nums.length > 2)
            while (nums[left] > nums[mid] || nums[mid] > nums[right]) {
                a = left;
                if (nums[mid] < nums[left]) right = mid - 1;
                else if (nums[mid] > nums[right]) left = mid + 1;
                mid = (left + right) / 2;
            }
        while ((a + 1 < nums.length) && (nums[a] < nums[a + 1])) a++;
        return a+1;
    }

    public static int search(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;
        while (left <= right) {
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
            mid = (left + right) / 2;
        }
        if (nums[mid] != target) return -1;
        return mid;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1};
        System.out.println(search(nums, 1));
    }
}
