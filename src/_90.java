import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hppppppf
 * @date 2022/5/11 11:10
 * @description
 */
public class _90 {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, false);
        return ans;
    }

    public void dfs(int[] nums, int cur, boolean choosePre) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(nums, cur + 1, false);
        if (!choosePre && cur > 0 && nums[cur] == nums[cur - 1])
            return;
        //123XX456 如果第一个X没选，那么第二个不能选，如果选了则会和只选第1个X重复
        list.add(nums[cur]);
        dfs(nums, cur + 1, true);
        list.remove(list.size() - 1);
    }
}
