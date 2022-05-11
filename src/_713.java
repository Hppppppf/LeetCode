/**
 * @author Hppppppf
 * @date 2022/5/8 14:09
 * @description https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class _713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        if(nums.length == 0)    return 0;
        long product = 1;
        int left = 0;
        for (int right = 0; right < nums.length;right++){
            product *= nums[right];
            while (left <= right && product >= k){
                product /= nums[left];
                left++;
            }
            ans += right - left + 1;//只包含新加入元素的子数组
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(
                numSubarrayProductLessThanK(new int[]{100,5,2,6}
                        ,100));
    }
}
