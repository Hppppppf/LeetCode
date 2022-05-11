public class _283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
    public static void moveZeroes(int[] nums) {
        /*
        //直接计算最终位置
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)   count++;
            else if (nums[i] != 0 && count > 0){
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
         */

        //从前往后遍历移动（快排
        int a = 0;
        int b = 0;
        while (a < nums.length){
            if (nums[a] != 0 && a > b){
                if (nums[b] == 0){
                    nums[b] = nums[a];
                    nums[a] = 0;
                }else a--;
                b++;
            }
            a++;
        }
    }
}
