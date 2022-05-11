import java.lang.reflect.Array;

public class _66 {
    public static void main(String[] args) {
        int[] X = new int[]{0};
        int[] Y = plusOne(X);
        for (int i = 0; i < Y.length; i++) {
            System.out.print(Y[i]);
        }
    }
    public static int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0 && digits[index] == 9){
            digits[index] = 0;
            index--;
        }
        if (index != -1){
            digits[index] ++;
            return digits;
        }else {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        }
    }
}
