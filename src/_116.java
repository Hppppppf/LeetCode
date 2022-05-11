import java.util.LinkedList;
import java.util.Queue;

public class _116 {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};
	public static Node connect(Node root) {
		if (root == null)   return root;
		LevelOrder(root);
		return root;
	}
	public static void LevelOrder(Node root){
		int flag = 0;
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		Node p = root;
		while(!Q.isEmpty()){
			Node q = Q.poll();
			flag++;
			if ((flag & (flag-1)) == 0)//判断是否为2的幂
				p.next = null;
			else p.next = q;
			p = q;
			if (p.left != null) {
				Q.offer(p.left);
				Q.offer(p.right);
			}
		}
	}
	public static void main(String[] args) {

	}
}
