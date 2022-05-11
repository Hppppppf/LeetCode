public class _34 {
    public static void main(String[] args) {

    }
    public static int[] searchRange(int[] nums, int target) {
        int i = -1, j = -1;
        if (nums.length >= 1){
            int left = 0, right = nums.length - 1;
            while (left <= right){
                int mid = (right - left) / 2 + left;
                System.out.println(left+","+mid+","+right);
                if (nums[mid] < target)	left = mid + 1;
                else if (nums[mid] > target)	right = mid - 1;
                else {
                    int temp1 = mid-1, temp2 = mid+1;
                    while (temp1 >= 0 && nums[temp1] == nums[mid])
                        temp1--;
                    while (temp2 < nums.length && nums[temp2] == nums[mid])
                        temp2++;
                    i = temp1 + 1;
                    j = temp2 - 1;
                    break;
                }
            }
        }
        return new int[]{i, j};
    }
}
