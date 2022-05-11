import java.util.*;

/**
 * @Author: Hppppppf
 * @Date: 2022/3/6 17:54
 * @Description: https://www.lanqiao.cn/problems/504/learning/
 */
public class LQ_DanCiFenXi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in = scan.next();
        scan.close();
        int[] alaphbet = new int[26];
        for (int i = 0; i < in.length(); i++) {
            alaphbet[in.charAt(i)-'a']++;
        }
        int index = 0;
        for (int i = 1; i < 26; i++) {
            if (alaphbet[i] > alaphbet[index])    index = i;
        }
        System.out.println((char)(index+'a'));
        System.out.print(alaphbet[index]);
    }
}
