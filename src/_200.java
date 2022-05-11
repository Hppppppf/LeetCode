/**
 * @author Hppppppf
 * @date 2022/5/8 17:49
 * @description https://leetcode-cn.com/problems/number-of-islands/
 */
public class _200 {
    public static int m = 0, n = 0;

    public static int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (i - 1 >= 0) dfs(grid, i - 1, j);
            if (j - 1 >= 0) dfs(grid, i, j - 1);
            if (i + 1 < m) dfs(grid, i + 1, j);
            if (j + 1 < n) dfs(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}}));
    }
}
