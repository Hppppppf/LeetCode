public class _167 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,25,75};
        int[] ret = twoSum(nums,100);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        /*//1.遍历
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target)  return new int[]{i+1,j+1};
            }
        }
        return new int[]{0,0};*/
        /*//2.二分查找
        for (int i = 0; i < numbers.length; i++) {
            int target2 = target - numbers[i];
            //在i-numbers.length之间进行二分查找
            int a = i + 1;
            int b = numbers.length - 1;
            while (a <= b){
                int mid = (a + b) / 2;
                if (numbers[mid] < target2){
                    a = mid + 1;
                }else if (numbers[mid] > target2){
                    b = mid - 1;
                }else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return new int[]{0,0};*/
        //3.双指针左右逼近
        int a = 0;
        int b = numbers.length - 1;
        while (true){
            if (numbers[a] + numbers[b] > target)   b--;
            else if (numbers[a] + numbers[b] < target)   a++;
            else return new int[]{a + 1, b + 1};
        }
    }
}
