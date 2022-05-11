public class _189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        _189.rotate(nums,2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        return;
    }
    public static void rotate(int[] nums, int k) {
        // 3.使用一个temp暂存，反复交换,直到n个数被放到正确位置
        // TODO
        // 4.翻转：整体翻转再部分翻转
        k = k % nums.length;
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        for (int i = 0; i < k / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[k - 1 - i];
            nums[k - i - 1] = temp;
        }
        for (int i = k; i < (nums.length - k) / 2 + k; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - (i - k)];
            nums[nums.length - 1 - (i - k)] = temp;
        }
        /*
        // 2.使用一个长度为n的数组接一部分溢出的元素
        k = k % nums.length;//防止特殊的K
        int[] temp = new int[nums.length];
        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++)
            temp[j++] = nums[i];
        for (int i = nums.length - k - 1; i >= 0 ; i--) {//为避免后面的数被覆盖，需要从后往前
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++)
            nums[i] = temp[i];
        */

        /*
        //1.使用新数组，时间O(n),空间O(n)
        int[] r = rotated(nums,k);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r[i];
        }
         */
    }

    private static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    //1.使用新数组，时间O(n),空间O(n)
    public static int[] rotated(int[] nums, int k){

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[(i + k) % nums.length] = nums[i];
        }
        return ret;
    }
}
