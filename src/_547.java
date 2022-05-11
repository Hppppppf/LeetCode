/**
 * @author Hppppppf
 * @date 2022/5/8 18:01
 * @description https://leetcode-cn.com/problems/number-of-provinces/
 */
public class _547 {
    public static int n;

    public static int findCircleNum(int[][] isConnected) {
        int ans = 0;
        n = isConnected.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (isConnected[i][j] == 1) {
                    ans++;
                    dfs(isConnected, i, j);
                }
            }
        }
        return ans;
    }

    public static void dfs(int[][] isConnected, int i, int j) {
        if (i >= j && isConnected[i][j] == 1) {
            isConnected[i][j] = 2;
            int ii = j, jj = 0;
            while (jj <= i)  dfs(isConnected,i,jj++);
            while (ii < n)    dfs(isConnected,ii++,j);
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }
}
