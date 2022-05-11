/**
 * @author Hppppppf
 * @date 2022/5/3 10:18
 * @description https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class _153 {
    /**
     * 二分搜索旋转点
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        int left = 0, right = nums.length - 1;
        int mid = left / 2 + right / 2;
        while ((nums[left] > nums[mid] || nums[mid] > nums[right]) && left < right - 2) {
            if (nums[left] > nums[mid]) right = mid;
            if (nums[mid] > nums[right]) left = mid;
            mid = left / 2 + right / 2;
        }
        if (left >= right - 2) {
            return Math.min(Math.min(nums[left], nums[left + 1]), nums[right]);
        } else return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1}));
    }
}
