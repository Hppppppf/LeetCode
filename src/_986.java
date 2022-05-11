import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hppppppf
 * @date 2022/5/5 14:17
 * @description https://leetcode-cn.com/problems/interval-list-intersections/
 */
public class _986 {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ret = new ArrayList<>();
        int p = 0, q = 0;
        while (p < firstList.length && q < secondList.length) {
            int start = Math.max(firstList[p][0], secondList[q][0]);
            int end = Math.min(firstList[p][1], secondList[q][1]);
            if (start <= end) {
                ret.add(new int[]{start, end});
                if (firstList[p][1] < secondList[q][1]) p++;
                else q++;
            }
            else if (firstList[p][1] < secondList[q][0])
                p++;
            else q++;
        }
        return ret.toArray(new int[ret.size()][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
    }
}
