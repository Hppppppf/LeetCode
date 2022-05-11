import java.util.ArrayList;
import java.util.List;

public class _210 {
	static List<List<Integer>> edges;
	static int[] visited;
	static int[] result;
	static boolean valid;
	static int index;

	public static void main(String[] args) {
		int numCourses = 3;
		int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}};
		int[] ret = findOrder(numCourses, prerequisites);
		for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i] + " ");
		}
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		// 存储有向图
		edges = new ArrayList<List<Integer>>();
		// 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
		visited = new int[numCourses];
		// 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
		result = new int[numCourses];
		// 判断有向图中是否有环
		valid = true;
		// 栈下标
		index = numCourses - 1;
		for (int i = 0; i < numCourses; ++i) {
			edges.add(new ArrayList<Integer>());
		}
		for (int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
		}
		// 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
		for (int i = 0; i < numCourses && valid; ++i) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}
		if (!valid) {
			return new int[0];
		}
		// 如果没有环，那么就有拓扑排序
		return result;
	}

	public static void dfs(int u) {
		// 将节点标记为「搜索中」
		visited[u] = 1;
		// 搜索其相邻节点
		// 只要发现有环，立刻停止搜索
		for (int v : edges.get(u)) {
			// 如果「未搜索」那么搜索相邻节点
			if (visited[v] == 0) {
				dfs(v);
				if (!valid) {
					return;
				}
			}
			// 如果「搜索中」说明找到了环
			else if (visited[v] == 1) {
				valid = false;
				return;
			}
		}
		// 将节点标记为「已完成」
		visited[u] = 2;
		// 将节点入栈
		result[index--] = u;
	}
}
