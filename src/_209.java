import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hppppppf
 * @date 2022/5/8 16:15
 * @description https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class _209 {
    /*public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        for (; right < nums.length; right++) {
            sum += nums[right];
            if (sum >= target) ans = Math.min(ans, right - left + 1);
            while (left <= right && sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) ans = Math.min(ans, right - left + 1);
        }
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }*/

    /**
     * 队列模拟滑动窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left= 0,right = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                ans = Math.min(ans, right - left);
                sum -= nums[left++];
            }
        }
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
}
