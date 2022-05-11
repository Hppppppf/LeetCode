import java.util.Comparator;
import java.util.Stack;

/**
 * @author Hppppppf
 * @date 2022/5/5 13:00
 * @description https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class _844 {
    /**
     * 分别处理完成后比较
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder tb = new StringBuilder(t);
        int index = sb.indexOf("#");
        while (index != -1) {
            if (index == 0)
                sb.delete(0, 1);
            else sb.delete(index - 1, index + 1);
            index = sb.indexOf("#");
        }
        index = tb.indexOf("#");
        while (index != -1) {
            if (index == 0)
                tb.delete(0, 1);
            else tb.delete(index - 1, index + 1);
            index = tb.indexOf("#");
        }
        return sb.toString().equals(tb.toString());
    }
    //TODO
    /*public static boolean backspaceCompare(String s, String t) {
        int p = s.length() - 1;
        int q = t.length() - 1;
        int count = 0;
        while (p >= 0 && q >= 0) {
            while (p >= 0 && s.charAt(p) == '#') {
                count++;
                p--;
            }
            if (count <= p)
                while (p > -1 && count > 0) {
                    p--;
                    if (p >= 0 && s.charAt(p) != '#') p--;
                    count--;
                }
            else p = -1;
            while (q >= 0 && t.charAt(q) == '#') {
                count++;
                q--;
            }
            if (count <= q)
                while (q > -1 && count > 0) {
                    q--;
                    if (q >= 0 && t.charAt(q) != '#') p--;
                    count--;
                }
            else q = -1;
            if (p >= 0 && q >= 0 && s.charAt(p) != t.charAt(q)) return false;
            if (p * q <= 0 && (p < 0 || q < 0)) return false;
            p--;
            q--;
        }
        while (p >= 0 && s.charAt(p) == '#') p--;
        while (q >= 0 && t.charAt(q) == '#') q--;
        return p < 0 && q < 0;
    }*/

    public static void main(String[] args) {
        System.out.println(backspaceCompare("nzp#o#g", "b#nzp#o#g"));
    }
}
