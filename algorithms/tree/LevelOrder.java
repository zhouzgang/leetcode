package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 *
 * @author brian.zhou
 * @date 2/15/22
 */
public class LevelOrder {

    /**
     * 广度优先
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> deepList = new LinkedList<>();
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
            deepList.add(breathList);
        }
        return deepList;
    }
}
