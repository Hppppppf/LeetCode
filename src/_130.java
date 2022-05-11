/**
 * @author Hppppppf
 * @date 2022/5/10 20:16
 * @description https://leetcode.cn/problems/surrounded-regions/
 */
public class _130 {
    static int m, n;

    public static void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[m - 1][i] == 'O') dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = 'A';
            if (i - 1 >= 0) dfs(board, i - 1, j);
            if (i + 1 < m) dfs(board, i + 1, j);
            if (j - 1 >= 0) dfs(board, i, j - 1);
            if (j + 1 < n) dfs(board, i, j + 1);
        }
    }

    public static void main(String[] args) {
        solve(new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}});
        System.out.println();
    }
}
