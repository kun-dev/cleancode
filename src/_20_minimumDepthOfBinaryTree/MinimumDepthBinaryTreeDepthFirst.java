/*
 * Givin a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root
 * ndoe down to the nearest leaf node.
 * Depth-first traversal: O(n) runtime, O(logn) space.
 * make sure consider these cases:
 * 1. the node itself is a leaf node. The minimum depth is one.
 * 2. node that has one empty sub-tree while the other one is non-empty. Return
 * the minimun depth of that non-empty sub-tree.
 */
package _20_minimumDepthOfBinaryTree;

/**
 *
 * @author I300939
 */
public class MinimumDepthBinaryTreeDepthFirst {
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
}
