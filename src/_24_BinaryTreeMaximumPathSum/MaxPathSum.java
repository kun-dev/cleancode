/*
 * Givin a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree. We need to return the
 * maximum path sum that goes through this node and to either one of its left or
 * right subtree to its parent. There's a little trick here: if this maximun
 * happens to be negative, we should return 0, which means: "Do not include this
 * subtree as part of the maximum path of the parent node.
 */
package _24_BinaryTreeMaximumPathSum;

/**
 *
 * @author I300939
 */
public class MaxPathSum {
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }
    
    private int findMax(TreeNode p) {
        if (p == null) return 0;
        int left = findMax(p.left);
        int right = findMax(p.right);
        maxSum = Math.max(p.val + left + right, maxSum);
        int ret = p.val + Math.max(left, right);
        return ret > 0 ? ret : 0;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
}
