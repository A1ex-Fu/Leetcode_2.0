public class SymmetricTree {
	/**
	 * 
	 * @param p
	 * @param q
	 * @return
	 */

	public boolean isSymmetric(TreeNode root) {
		TreeNode p = root.right;
		TreeNode q = root.left;

		// pass the left and right child nodes to the helper method
		return isSymmetricHelper(p, q);
	}

	/**
	 * Checks whether the two trees are "symmetric"
	 * 
	 * @param p - the first subtree's root node
	 * @param q - the second subtree's root node
	 * @return true if the two trees are "symmetric" and false otherwise
	 */
	public boolean isSymmetricHelper(TreeNode p, TreeNode q) {

		// return their equality and recursively call this on the child nodes

		// check if one is null - if neither is null, check that the values are equal
		// otherwise, check if both are null and thereby equivalent
		if (p == null || q == null) {
			if (p == q) {
				return true;
			} else {
				return false;
			}
		} else if (p.val != q.val) {
			return false;
		}

		return isSymmetricHelper(p.right, q.left) && isSymmetricHelper(p.left, q.right);
	}

	/**
	 * Provided tree implementation
	 * 
	 * @author LeetCode
	 *
	 */
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
