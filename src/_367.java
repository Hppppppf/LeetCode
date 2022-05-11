public class _367 {
    public static void main(String[] args) {
        int num = 2147395600;
        System.out.println(isPerfectSquare(num));
    }
    //不使用内置库函数 1.二分查找
    public static boolean isPerfectSquare(int num) {
        int a = 0;
        int b = num;
        while (b - a > 1){
            int mid = (b - a) / 2 + a;
            if (mid > 46340){// 考虑越界结果
                b = mid;
                continue;
            }
            System.out.println(mid+"^2="+mid*mid);
            if (mid * mid > num)    b = mid;
            else if (mid * mid < num)   a = mid;
            else return true;
        }
        if (b * b == num)   return true;
        else return false;
    }
    /*
    //使用内置库函数
    public static boolean isPerfectSquare(int num) {
        int temp = (int)Math.sqrt(num);
        return temp*temp == num;
    }
    */
}
