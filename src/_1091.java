import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hppppppf
 * @date 2022/5/9 16:20
 * @description https://leetcode.cn/problems/shortest-path-in-binary-matrix/
 */
public class _1091 {
    static int n;
    static int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public static int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0)    return -1;
        grid[n-1][n-1] = -1;
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int last = grid[cur[0]][cur[1]];
            for (int i = 0; i < 8; i++) {
                if (cur[0] + dir[i][0] >= 0
                        && cur[0] + dir[i][0] < n
                        && cur[1] + dir[i][1] >= 0
                        && cur[1] + dir[i][1] < n
                        && grid[cur[0] + dir[i][0]][cur[1] + dir[i][1]] <= 0) {
                    queue.add(new int[]{cur[0] + dir[i][0],cur[1] + dir[i][1]});
                    grid[cur[0] + dir[i][0]][cur[1] + dir[i][1]] = last + 1;
                }
            }
        }
        return grid[n-1][n-1];
    }
    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0,0,1,0,0,0,0},
                {0,1,0,0,0,0,1},
                {0,0,1,0,1,0,0},
                {0,0,0,1,1,1,0},
                {1,0,0,1,1,0,0},
                {1,1,1,1,1,0,1},
                {0,0,1,0,0,0,0}}));
    }
}
