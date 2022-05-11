public class _977 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,2};
        int[] ret = sortedSquares(nums);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i]+" ");
        }
    }
    public static int[] sortedSquares(int[] nums) {
        /*没有用题目中的非减序列这一条件
        //尝试用计数排序
        //确定max,min
        int min = abs(nums[0]);
        int max = abs(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            if (abs(nums[i]) < min)  min = abs(nums[i]);
            else if (abs(nums[i]) > max) max = abs(nums[i]);
        }
        //
        int offset = max - min + 1;
        int[] count = new int[offset];
        for (int i = 0; i < nums.length; i++) {
            count[abs(nums[i]) - min]++;
        }
        //
        int[] ret = new int[nums.length];
        int p = 0;
        for (int i = 0; i < offset; i++) {
            if (count[i] != 0){
                for (int j = count[i]; j > 0; j--)
                    ret[p++] = (i + min) * (i + min);
            }
        }
        return  ret;
         */

        //寻找abs最小元素
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0){
                start = i;
                break;
            }
        }
        if (start == -1)//考虑元素全为负的情况
            start = nums.length - 1;
        else if (start == 0) {//考虑元素全为正的情况
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }else {
            start = nums[start] < -nums[start - 1]? start : start - 1;
        }

        //从两侧分别选择元素放入ret
        int negative = start - 1,postive = start + 1;
        int[] ret = new int[nums.length];
        ret[0] = nums[start] * nums[start];
        int index = 1;
        while (negative >= 0 && postive < nums.length){
            if ((-1)*nums[negative] < nums[postive]){
                ret[index++] = nums[negative] * nums[negative];
                negative--;
            }else{
                ret[index++] = nums[postive] * nums[postive];
                postive++;
            }
        }
        if (negative < 0)
            while (postive < nums.length){
                ret[index++] = nums[postive] * nums[postive];
                postive++;
            }
        else if (postive == nums.length)
            while (negative >= 0){
                ret[index++] = nums[negative] * nums[negative];
                negative--;
            }
        return ret;
    }
    public static int abs(int x){
        return x < 0? -x:x;
    }
}
