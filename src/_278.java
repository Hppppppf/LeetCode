public class _278 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        //left-----mid-----right
        while (left < right){
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid))  right = mid;//left--*--mid-----right
            else left = mid + 1;//left-----mid--*--right
        }
        return left;
    }
    static boolean  isBadVersion(int version){
        if (version >= 1702766719)
            return true;
        else  return  false;
    }
}
