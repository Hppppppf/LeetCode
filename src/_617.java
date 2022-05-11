public class _617 {
	public static void main(String[] args) {

	}

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 != null && root2 != null) {
			root1.val += root2.val;
			root1.left = mergeTrees(root1.left, root2.left);
			root1.right = mergeTrees(root1.right, root2.right);
		} else if (root2 != null) {
            root1 = root2;
		}
		return root1;
	}

	public class TreeNode {
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
