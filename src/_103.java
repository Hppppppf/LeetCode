import java.util.*;

public class _103 {
    public static void main(String[] args) {
        int[] input = {};
        TreeNode root = new TreeNode(input[0]);
        if (input.length > 1){
            for (int i = 1; i < input.length; i++) {

            }
        }


    }
    static public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null)   return ret;
        Stack<TreeNode> S = new Stack<>();
        S.push(root);
        L2R(S,ret);
        return ret;
    }
    static public void L2R(Stack<TreeNode> S,List<List<Integer>> ret){
        if (S.isEmpty())    return;
        List<Integer> temp = new ArrayList<>();
        Stack<TreeNode> St = new Stack<>();
        while (!S.isEmpty()){
            TreeNode p = S.pop();
            temp.add(p.val);
            if (p.left != null) St.push(p.left);
            if (p.right != null)    St.push(p.right);
        }
        ret.add(temp);
        R2L(St,ret);
    }
    static public void R2L(Stack<TreeNode> S,List<List<Integer>> ret){
        if (S.isEmpty())    return;
        List<Integer> temp = new ArrayList<>();
        Stack<TreeNode> St = new Stack<>();
        while (!S.isEmpty()){
            TreeNode p = S.pop();
            temp.add(p.val);
            if (p.right != null)    St.push(p.right);
            if (p.left != null) St.push(p.left);
        }
        ret.add(temp);
        R2L(St,ret);
    }
    static public class TreeNode {
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
}
