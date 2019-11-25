/*
 * Note depth first approach traverses all the nodes even for a highly unbalanced
 * tree. In fact, we could optimize this scenario by doing a breath-first traversal
 * (also known as level-order traversal). When we encounter the first leaf node,
 * we immediately stop the traversal.
 * We also keep track of the current depth and increment it when we reach the end
 * of level. We know that we have reached the end level when the current node is
 * the right-most node.
 * Compared to the recursion approach, the breath-first traversal works well the
 * highly unbalanced tree because it doesn't need to traverse all nodes.
 */
package _20_minimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author I300939
 */
public class MinimumDepthBinaryTreeBreathFirst {
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode rightMost = root;
        int depth = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left == null && node.right == null) break;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            if (node == rightMost) {
                depth++;
                rightMost = (node.right != null) ? node.right : node.left;
            }
        }
        return depth;
    }
}
