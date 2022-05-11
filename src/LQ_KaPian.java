/**
 * @Author: Hppppppf
 * @Date: 2022/3/6 17:03
 * @Description: https://www.lanqiao.cn/problems/1443/learning/
 */
public class LQ_KaPian {
    public static void main(String[] args) {
        int[] cards = new int[10];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = 2021;
        }
        int ret = 1;
        boolean flag = false;
        while (true) {
            int tempRet = ret;
            while (tempRet != 0) {
                if (--cards[tempRet % 10] < 0) {
                    flag = true;
                    break;
                }
                tempRet /= 10;
            }
            if (flag) {
                System.out.println(ret - 1);
                return;
            }
            ret++;
        }
    }
}
