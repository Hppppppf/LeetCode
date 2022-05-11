import java.util.LinkedList;
import java.util.Queue;

public class _542 {
	public static void main(String[] args) {
		_542 Test = new _542();
		int[][] mat = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
		int[][] answer = Test.updateMatrix(mat);
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}

	public int[][] updateMatrix(int[][] mat) {
		int MAX = 100000;
		Queue<int[]> Q = new LinkedList<>();
		int m = mat.length, n = mat[0].length;
		int[][] distance = new int[m][n];
		boolean[][] status = new boolean[m][n];//boolean默认值是false
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					distance[i][j] = 0;
					Q.offer(new int[]{i,j});
					status[i][j] = true;
				}
				else distance[i][j] = MAX;
			}
		}
		while (!Q.isEmpty()){
			int[] current = Q.poll();
			int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
			for (int[] dir : direction) {
				int new_i = current[0] + dir[0];
				int new_j = current[1] + dir[1];
				if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && !status[new_i][new_j]){
					distance[new_i][new_j] = distance[current[0]][current[1]] + 1;
					status[new_i][new_j] = true;
					Q.offer(new int[]{new_i,new_j});
				}
			}
		}
		return distance;
	}
}
