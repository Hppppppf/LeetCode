public class _1688 {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(7));
    }

    static public int numberOfMatches(int n) {
        int sum = 0;
        while (n >= 2) {
            if ((n & 1) == 1) {
                n = n >> 1;
                sum += n;
                n++;
            } else {
                n = n >> 1;
                sum += n;
            }
        }
        return sum;
    }
}
