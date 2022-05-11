public class _557 {
    public static void main(String[] args) {
        String S = "Let's take LeetCode contest";
        System.out.println(reverseWords(S));
    }
        public static String reverseWords(String s) {
            String[] ss = s.split(" ");
            StringBuffer ret = new StringBuffer();
            for (int i = 0; i < ss.length; i++){
                StringBuffer temp = new StringBuffer(ss[i]);
                temp.reverse();
                ret.append(temp.toString()+" ");
            }
            ret.delete(ret.length()-1,ret.length());
            return ret.toString();
        }
}
