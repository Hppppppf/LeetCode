import java.util.ArrayList;
import java.util.List;

/**
 * @author Hppppppf
 * @date 2022/5/7 20:34
 * @description https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class _438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) return ans;
        int[] count = new int[26];
        int diff = 0;
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i)-'a'] ++;
            count[s.charAt(i)-'a'] --;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) diff++;
        }
        char oldChar, newChar;
        int index = 0;
        for (; index < s.length() - p.length(); index++) {
            if (diff == 0)  ans.add(index);
            oldChar = s.charAt(index);
            if (count[oldChar-'a'] == -1) diff--;
            else if (count[oldChar-'a'] == 0)   diff++;
            count[oldChar-'a'] ++;
            newChar = s.charAt(index+p.length());
            if (count[newChar-'a'] == 1) diff--;
            else if (count[newChar-'a'] == 0)   diff++;
            count[newChar-'a'] --;
        }
        if (diff == 0) ans.add(index);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd"
                , "abc"));
    }
}
