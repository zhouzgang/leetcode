package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 * 1. 暴力解法，使用 102 的代码，将结果反转一下。
 * 那么为什么不再 add 的时候反着 add 呢。
 *
 * @author brian.zhou
 * @date 2/15/22
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        LinkedList<List<Integer>> deepList = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> breathList = new LinkedList<>();
            while (size > 0) {
                TreeNode r = queue.poll();
                breathList.add(r.val);
                if (r.left != null) {
                    queue.offer(r.left);
                }
                if (r.right != null) {
                    queue.offer(r.right);
                }
                size--;
            }
            deepList.addFirst(breathList);
        }
        return deepList;
    }


}
