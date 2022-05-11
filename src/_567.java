import java.util.HashMap;
import java.util.Set;

public class _567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","adboaoo"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())  return false;
        int[] alaphbet = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alaphbet[s1.charAt(i)-'a']++;
            alaphbet[s2.charAt(i)-'a']--;
        }
        int diff_count = 0;
        for (int i = 0; i < 26; i++) {
            if (alaphbet[i] != 0)   diff_count++;
        }
        if (diff_count == 0)    return true;
        //滑动窗口
        int left = 1;
        int right = left + s1.length() - 1;
        while (diff_count != 0 && right < s2.length()){
            int x = s2.charAt(left - 1);
            int y = s2.charAt(right);
            if (x == y) {
                left++;
                right++;
                continue;//左边出去的和右边进来的相同
            }
            if (alaphbet[x - 'a'] == 0) diff_count++;
            alaphbet[x - 'a']++;
            if (alaphbet[x - 'a'] == 0) diff_count--;
            if (alaphbet[y - 'a'] == 0) diff_count++;
            alaphbet[y - 'a']--;
            if (alaphbet[y - 'a'] == 0) diff_count--;
            left++;
            right++;
        }
        if (diff_count == 0)    return true;
        else return false;
    }
}
