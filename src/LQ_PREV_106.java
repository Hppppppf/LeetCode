import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hppppppf
 * @date 2022/4/4 16:37
 * @description http://lx.lanqiao.cn/problem.page?gpid=T2734
 */
public class LQ_PREV_106 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> arr = new LinkedList<>();
        int[] mark = new int[1000000];//mark[index]表示该数后第一个未重复的数
        for (int i = 0; i < mark.length; i++) {//需要初始化？
            mark[i] = i;
        }
        for (int i = 0; i < N; i++) {
            int in = scanner.nextInt();
            if (mark[in] != in){
                int index = mark[in];
                fun(index,mark);
                arr.add(index);
            }else {
                arr.add(in);
                fun(in,mark);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
        }
    }
    public static void fun(int index,int[] mark){
        //找后面的空位，放到前面原来指向index的位置
        int indexTemp = mark[index+1];
        for (int i = index; i > 0; i--) {
            if (mark[i] == index)   mark[i] = indexTemp;
            else break;
        }
    }
}
