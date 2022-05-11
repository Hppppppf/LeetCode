import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: Hppppppf
 * @Date: 2022/3/7 19:39
 * @Description: https://www.lanqiao.cn/problems/507/learning/
 */
public class LQ_ZhuangShiZhu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //装备
        int[][] Item = new int[6][50];
        int HoleNumMax = 0;
        for(int i = 0; i < 6; i++){
            int HoleNum = scan.nextInt();
            if (HoleNum > HoleNumMax)   HoleNumMax = HoleNum;
            System.out.print( HoleNum+"Holes of Item"+i+":");
            for (int j = 0; j < HoleNum; j++) {
                Item[i][j] = scan.nextInt();
                System.out.print(" "+Item[i][j]);
            }
            System.out.println();
        }
        //装饰珠
        int Pearls = scan.nextInt();
        int[][] PearlNum = new int[Pearls][2];
        int[][] Pearl = new int[Pearls][7];
        for (int i = 0; i < Pearls; i++) {
            PearlNum[i][0] = scan.nextInt();
            PearlNum[i][1] = scan.nextInt();
            System.out.print("Pearl "+i+" Lv"+ PearlNum[i][0]+" Limit:"+ PearlNum[i][1]);
            for (int j = 0; j < PearlNum[i][1]; j++) {
                Pearl[i][j] = scan.nextInt();
            }
            System.out.println();
        }
        scan.close();

        //01背包

    }
}
