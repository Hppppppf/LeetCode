import java.util.Arrays;
import java.util.List;

/**
 * @author Hppppppf
 * @date 2022/5/3 10:38
 * @description https://leetcode-cn.com/problems/find-peak-element/
 */
public class _162 {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int left = 0, right = nums.length - 1;
        int mid = left / 2 + right / 2;
        while ( right - left >= 2 && ((nums[mid + 1] - nums[mid]) * (nums[mid] - nums[mid - 1]) >= 0 || nums[mid] < nums[mid+1]) ) {
            if (nums[mid + 1] - nums[mid] > 0) left = mid + 1;
            else right = mid - 1;
            mid = left / 2 + right / 2;
        }
        if (right - left < 2) return nums[left]>nums[right]?left:right;
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{3,1,2}));
    }
}
