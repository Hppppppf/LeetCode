public class _1299 {
	public static void main(String[] args) {
		int[] test = new int[]{400};
		int[] ret = replaceElements(test);
		for (int i = 0; i < ret.length; i++) {
			System.out.print(ret[i]+" ");
		}
	}
	static public int[] replaceElements(int[] arr) {
		int[] ret = new int[arr.length];
		ret[arr.length-1] = -1;
		int max = -1;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] > max)   max = arr[i];
			ret[i-1] = max;
		}
		return ret;
	}
}
