import java.net.Inet4Address;
import java.util.*;

/**
 * @author Hppppppf
 * @date 2022/5/10 21:02
 * @description https://leetcode.cn/problems/all-paths-from-source-to-target/
 */
public class _797 {
    int end;
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        if (graph.length == 0)  return ans;
        end = graph.length - 1;
        stack.offerFirst(0);
        dfs(graph,0);
        return ans;
    }
    public void dfs(int[][] graph,int cur){
        if (cur == end) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int next : graph[cur]){
            stack.offerFirst(next);
            dfs(graph,next);
            stack.removeFirst();
        }
    }
}
