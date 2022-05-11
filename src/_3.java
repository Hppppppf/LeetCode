public class _3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] alaphbet = new int[128];//ASCII标准字符128个
        for (int i = 0; i < 128; i++)	alaphbet[i] = -1;
        int left = 0, right = 0;
        int len = 0, max = 0;
        while (right < s.length()){
            if (alaphbet[s.charAt(right)] == -1){
                alaphbet[s.charAt(right)] = right;
                len++;
            }else{
                left = alaphbet[s.charAt(right)] + 1 > left ? alaphbet[s.charAt(right)] + 1 : left;
                alaphbet[s.charAt(right)] = right;
                len = right - left + 1;
            }
            if (len > max) max = len;
            //System.out.println(left+" "+right);
            right++;
        }
        return max;
    }
}
