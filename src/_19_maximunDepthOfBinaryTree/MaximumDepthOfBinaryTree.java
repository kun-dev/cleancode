/*
 * Givin a binary tree, find its maximum depth. The maximum depth is the number
 * of nodes along the longest path from the root node down to the farthest leaf
 * node.
 * Solution:
 * The maximum height of a binary tree is defined as the number of nodes along
 * the path from the root node to the deepest leaf node. Note the maximum depth
 * of an empty tree is 0.
 * O(n) runtime, O(logn) space - Recursion:
 * We could solve this easily using recursion, because each of the left child
 * and right child of a node is sub-tree itself. We first compute the max height
 * of left sub-tree, and then compute the max height of right sub-tree. The
 * maximum depth of the current node is the greater of the two maximum plus one.
 * For base case, we look at a tree that is empty, which we return 0.
 * Assume that n is the total number of nodes in the tree. The runtime complexity
 * is O(n) because it traverse each node exactly once. As the maximum depth of
 * of a binary tree is O(logn), the extra space cost is O(logn) due to the extra
 * stack space used by the recursion.
 */
package _19_maximunDepthOfBinaryTree;

/**
 *
 * @author I300939
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
}
