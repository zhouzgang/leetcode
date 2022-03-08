package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * @author brian.zhou
 * @date 2/15/22
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Boolean turnLeft = true;
        queue.offer(root);
        LinkedList<List<Integer>> deepList = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> breathList = new LinkedList<>();
            turnLeft = !turnLeft;
            while (size > 0) {
                TreeNode r = queue.poll();
                breathList.add(r.val);

                if (turnLeft) {
                    if (r.left != null) {
                        queue.offer(r.left);
                    }
                    if (r.right != null) {
                        queue.offer(r.right);
                    }
                }else {
                    if (r.right != null) {
                        queue.offer(r.right);
                    }
                    if (r.left != null) {
                        queue.offer(r.left);
                    }
                }


                size--;
            }
            deepList.add(breathList);
        }
        return deepList;
    }
}
