import java.util.Scanner;

/**
 * @author Hppppppf
 * @date 2022/4/3 14:55
 * @description http://lx.lanqiao.cn/problem.page?gpid=T3000
 */
public class LQ_ALGO_1006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = map[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)   dp[i][j] = map[i][j];
                else if (j == 0){
                    //从上面来
                    dp[i][j] = dp[i-1][j] + map[i][j];
                }else if (i == 0){
                    //从左边来
                    dp[i][j] = dp[i][j-1] + map[i][j];
                }else {
                    dp[i][j] = (dp[i-1][j] > dp[i][j-1] ? dp[i-1][j]:dp[i][j-1])+map[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
