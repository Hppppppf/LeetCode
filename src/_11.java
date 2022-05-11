/**
 * @author Hppppppf
 * @date 2022/5/5 14:49
 * @description
 */
public class _11 {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                int temp = height[left];
                while (left < right && height[left] <= temp) left++;
            } else {
                int temp = height[right];
                while (left < right && temp >= height[right]) right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,4,3}));
    }
}
