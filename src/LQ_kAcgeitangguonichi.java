import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**
 * @author Hppppppf
 * @date 2022/3/27 17:11
 * @description
 */
public class LQ_kAcgeitangguonichi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n == 0 || m == 0){
            System.out.print(0);
            return;
        }

        Long count = 0L;
        Long A[] = new Long[n];
        for (int i = 0; i < n; i++){
            A[i] = scanner.nextLong();
        }
        if (n == 1 && m >= 1){
            System.out.println(A[0]);
            return;
        }
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 0 && m > 0 ; i--,m--) {
            count += A[i];
        }
        System.out.print(count);
        return;
    }
}
