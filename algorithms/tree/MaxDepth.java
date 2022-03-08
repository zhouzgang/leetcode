package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author brian.zhou
 * @date 2/15/22
 */
public class MaxDepth {

    /**
     * 深度优先
     *
     * @param root
     * @return
     */
    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right)) + 1;
    }

    /**
     * 广度优先
     *
     * @param root
     * @return
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            while (size > 0) {
                TreeNode r = queue.poll();
                if (r.left != null) {
                    queue.offer(r.left);
                }
                if (r.right != null) {
                    queue.offer(r.right);
                }
                size--;
            }
        }
        return ans;
    }
}
