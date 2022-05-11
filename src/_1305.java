import java.util.*;

/**
 * @author Hppppppf
 * @date 2022/5/2 15:33
 * @description https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 * 中序遍历+归并排序
 */
public class _1305 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }
    static ArrayList<Integer> ret = new ArrayList<>();
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inOrder(root1);
        inOrder(root2);

        /*int p = 0, q = 0;
        List<Integer> ret = new ArrayList<>();
        while (p < l1.size() && q < l2.size()) {
            if (l1.get(p) <= l2.get(q)) {
                ret.add(l1.get(p));
                p++;
            } else {
                ret.add(l2.get(q));
                q++;
            }
        }
        if (p == l1.size()) ret.addAll(l2.subList(q, l2.size()));
        else ret.addAll(l1.subList(p, l1.size()));*/
        Collections.sort(ret);
        return ret;
    }


    public static void inOrder(TreeNode root) {

        if (root == null) return;
        inOrder(root.left);
        ret.add(root.val);
        inOrder(root.right);

    }
    /*
     */

    /**
     * 非递归 中序遍历
     *
     * @param root
     * @return
     *//*
    public static ArrayList<Integer> inOrder2(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        TreeNode p = root;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (!treeNodeStack.isEmpty() || p != null) {
            while (p != null) {
                treeNodeStack.push(p);
                p = p.left;
            }
            if (!treeNodeStack.isEmpty()) {
                p = treeNodeStack.pop();
                ret.add(p.val);
                p = p.right;
            }
        }
        return ret;
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        TreeNode p = root1;
        TreeNode q = root2;
        Stack<TreeNode> treeNodeStack1 = new Stack<>();
        Stack<TreeNode> treeNodeStack2 = new Stack<>();
        while (!treeNodeStack1.isEmpty() || p != null || !treeNodeStack2.isEmpty() || q != null) {
            while (p != null) {
                treeNodeStack1.push(p);
                p = p.left;
            }
            while (q != null) {
                treeNodeStack2.push(q);
                q = q.left;
            }
            if (!treeNodeStack1.isEmpty() && !treeNodeStack2.isEmpty()) {
                p = treeNodeStack1.pop();
                q = treeNodeStack2.pop();
            }


        }
        return list;
    }*/
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, null, 8));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(8, 1));
        System.out.println(getAllElements(buildTree(list), buildTree(list2)));
    }

    public static TreeNode buildTree(List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(list.get(0));
        stack.push(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode p = stack.pop();
            if (list.get(i) != null) {
                p.left = new TreeNode(list.get(i));
                stack.push(p.left);
            } else p.left = null;
            if (i + 1 < list.size() && list.get(i + 1) != null) {
                p.right = new TreeNode(list.get(i + 1));
                stack.push(p.right);
            } else p.right = null;
            i++;
        }
        return root;
    }
}
