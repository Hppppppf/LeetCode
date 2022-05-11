public class _695 {
	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,1,1,0,1,0,0,0,0,0,0,0,0},
						{0,1,0,0,1,1,0,0,1,0,1,0,0},
						{0,1,0,0,1,1,0,0,1,1,1,0,0},
						{0,0,0,0,0,0,0,0,0,0,1,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid));
	}
	public static int maxAreaOfIsland(int[][] grid) {
		int flag = 2;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1){
					grid = mark(grid,i,j,flag);
					flag++;
				}
			}
		}
		int[] count = new int[flag];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				count[grid[i][j]]++;
			}
		}
		int max = 0;
		if (flag > 2)   max = count[2];
		else return 0;
		for (int i = 2; i < count.length; i++) {
			if (count[i] > max) max = count[i];
		}
		return max;
	}
	public static int[][] mark(int[][] grid,int x,int y,int newFlag){
		if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
			grid[x][y] = newFlag;
			mark(grid,x-1,y,newFlag);
			mark(grid,x+1,y,newFlag);
			mark(grid,x,y-1,newFlag);
			mark(grid,x,y+1,newFlag);
		}
		return grid;
	}
}
