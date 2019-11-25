/*
 * Given a binary tree, determine if it is height balanced.
 * For this problem, a height balanced binary tree is defined as a binary tree
 * in which the depth of the two subtree of every node never differs by more
 * than 1.
 * Solution: We could avoid the recalculation by passing the depth bottom up.
 * We use a sentinel value -1 to represent that the tree is unblanced so we
 * could avoid unnecessary calculations. In each step, we look at the left
 * subtree's depth (L) and ask: "Is the left subtree unbalanced?" If it is indeed
 * unbalanced, we return -1 right away. Otherwise, L represents the left subtree's
 * depth. We then repeat the same process for the right subtree's depth (R). We
 * calculate the absolute difference between L and R. If the subtree's depth
 * difference is less than one, we could return the height of the current node,
 * otherwise return - meaning the current tree is unbalanced.
 */
package _21_balancedBinaryTree;

/**
 *
 * @author I300939
 */
public class BalancedBinaryTree {
    public boolean isBanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int L = maxDepth(root.left);
        if (L == -1) return -1;
        int R = maxDepth(root.right);
        if (R == -1) return -1;
        return ((Math.abs(L - R)) <= 1) ? (Math.max(L, R) + 1) : -1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
}
