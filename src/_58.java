public class _58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   a    "));
    }
    public static int lengthOfLastWord(String s) {
        int len = s.length();
        while (s.charAt(len - 1) == ' ')    len--;
        return len - s.lastIndexOf(' ', len - 1) - 1;
    }
}
