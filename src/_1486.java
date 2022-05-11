public class _1486 {
    public static void main(String[] args) {
        System.out.println(xorOperation(1,7));
    }
    static public int xorOperation(int n, int start) {
        int ret = start;
        for (int i = 1; i < n; i++) {
            ret = ret ^ (start + 2 * i);
        }
        return ret;
    }
}
