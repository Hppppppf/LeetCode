import java.util.ArrayList;
import java.util.List;

/**
 * @author Hppppppf
 * @date 2022/5/11 10:40
 * @description https://leetcode.cn/problems/subsets/
 */
public class _78 {
    /**
     * 借助Integer.toBinaryString实现子集枚举
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        int n = (int) Math.pow(2, nums.length);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String binaryStr = Integer.toBinaryString(i);
            List<Integer> oneAns = new ArrayList<>();
            System.out.println(binaryStr);
            for (int j = binaryStr.length() - 1; j >= 0; j--) {
                if (binaryStr.charAt(j) == '1') oneAns.add(nums[binaryStr.length() - 1 - j]);
            }
            ans.add(oneAns);
        }
        return ans;
    }

    /**
     * 递归
     * @param nums
     * @return
     */
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return ans;
    }
    public void dfs(int[] nums,int cur){
        if (cur == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        //选择当前
        list.add(nums[cur]);
        dfs(nums,cur+1);
        //不选择当前
        list.remove(list.size()-1);
        dfs(nums,cur+1);
    }

}
