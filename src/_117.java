import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hppppppf
 * @date 2022/5/9 14:11
 * @description https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class _117 {

    public Node connect(Node root) {
        //层次遍历的过程中处理
        Queue<Node> queue = new ArrayDeque<>();
        if (root == null) return root;
        queue.offer(root);
        int len = 0;
        int nextLen = 1;
        while (!queue.isEmpty()) {
            len = nextLen;
            nextLen = 0;
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                System.out.print("cur:" + cur.val);
                int j;
                for (j = i + 1; j < len; j++) {
                    if (queue.peek() == null) {
                        queue.poll();
                    } else break;
                }
                if (j == len) {
                    cur.next = null;
                } else {
                    cur.next = queue.peek();
                }
                if (cur.next != null) System.out.println("    next:" + cur.next.val + " " + j);
                else System.out.println("    next:" + null + " " + j);
                if (cur.left != null) {
                    queue.offer(cur.left);
                    nextLen++;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    nextLen++;
                }
                System.out.println(nextLen);
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
