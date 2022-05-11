import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Hppppppf
 * @date 2022/4/3 13:53
 * @description http://lx.lanqiao.cn/problem.page?gpid=T3002
 */
public class LQ_ALGO_1007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (m < n) {
            System.out.print("0.0000");
        } else if (n == 1) {
            System.out.print("1.0000");
        } else {
            //d[i][j]表示买i个收集j种
            double[][] dp = new double[m+1][n+1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i < j)  dp[i][j] = 0;//买的数量小于种数
                    else if (j == 1) {
                        dp[i][j] = Math.pow(1.0/n,i);//收集1种
                        dp[i][j] *= n;
                    }
                    else {
                        dp[i][j] = dp[i-1][j]*(j*1.0/n)     //1.买到重复
                                 + dp[i-1][j-1]*((n-(j-1))*1.0/n);    //2.买到新的
                }
            }
        }
            DecimalFormat df = new DecimalFormat("#0.0000");
            System.out.print(df.format(dp[m][n]));
        }
    }
}
