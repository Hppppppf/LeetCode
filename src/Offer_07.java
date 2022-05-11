import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Hppppppf
 * @Date: 2022/2/21 21:06
 * @Description:
 */
public class Offer_07 {
    public int[] pre_order, in_order;
    int head = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre_order = preorder;
        in_order = inorder;
        return rebuild(0, inorder.length - 1);
    }

    public TreeNode rebuild(int i, int j) {
        if (i > j) return null;
        TreeNode root = new TreeNode(pre_order[head]);
        head++;
        int index = i;
        for (; index <= j; index++) {
            if (root.val == in_order[index])    break;
        }
        root.left = rebuild(i, index - 1);
        root.right = rebuild(index + 1, j);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        Offer_07 test = new Offer_07();
        TreeNode T =  test.buildTree(preorder,inorder);
        System.out.println("OK");
    }

}
