import java.util.*;

/**
 * @author Hppppppf
 * @date 2022/5/4 14:07
 * @description https://leetcode-cn.com/problems/3sum/
 */
public class _15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 3) return ret;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    int temp = nums[j];
                    j++;
                    while (j < k && nums[j] == temp) j++;
                    temp = nums[k];
                    k--;
                    while (k > j && nums[k] == temp) k--;
                }
                while (j < k && nums[i] + nums[j] + nums[k] < 0) j++;
                while (k > j && nums[i] + nums[j] + nums[k] > 0) k--;
            }
            while (i + 1 < nums.length - 2 && Objects.equals(nums[i], nums[i + 1])) i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
