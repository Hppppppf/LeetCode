/**
 * @author Hppppppf
 * @date 2022/5/2 20:01
 * @description
 */
public class _74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 1;
        if (matrix.length > 1) {
            for (i = 1; i < matrix.length; i++) {
                if (target <= matrix[i][0]) break;
            }

            if (i < matrix.length && target == matrix[i][0]) return true;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i - 1][j] == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}, {4}};
        System.out.println(searchMatrix(matrix, 3));
    }
}
