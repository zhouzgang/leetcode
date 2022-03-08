package tree;

/**
 * 101. 对称二叉树
 *
 * @author brian.zhou
 * @date 2/15/22
 */
public class IsSymmetric {

    /**
     * 这个题要有拆分思考
     * 子问题拆分
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSubSymmetric(root.left, root.right);
    }

    public boolean isSubSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val
                && isSubSymmetric(left.left, right.right)
                && isSubSymmetric(left.right, right.left);
    }
}
