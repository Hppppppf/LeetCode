public class _733 {
	public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		image = floodFill(image,1,1,2);
		for (int i = 0; i < image.length; i++) {
			for (int i1 = 0; i1 < 3; i1++) {
				System.out.print(image[i][i1]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int oldColor = image[sr][sc];
		if (oldColor == newColor)   return image;
		return floodFill2(image,sr,sc,newColor,oldColor);
	}
	public static int[][] floodFill2(int[][] image, int sr, int sc, int newColor,int oldColor){
		if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == oldColor){
			image[sr][sc] = newColor;
			floodFill2(image,sr-1,sc,newColor,oldColor);
			floodFill2(image,sr+1,sc,newColor,oldColor);
			floodFill2(image,sr,sc-1,newColor,oldColor);
			floodFill2(image,sr,sc+1,newColor,oldColor);
		}
		return image;
	}
}
