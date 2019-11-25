/*
 * Given a binary tree, determine if it is a valid Binary Search Tree (BST).
 * First, you must understand a difference between Binary Tree and BST. Binary
 * tree is a tree data structure in which each node has at most two child notes.
 * A BST is based on binary tree, but with the following additional properties:
 * - The left subtree of a node contains only nodes with keys less than the
 *   nodes key.
 * - The right subtree of a node contains only nodes with keys greater than the
 *   node's key.
 * - Both the left and right subtree must also be binary search tree (BST)
 * O(n) runtime, O(n) stack space
 */
package _18_validate_BST_Recursion;

/**
 *
 * @author I300939
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean valid(TreeNode p, int low, int high) {
        if (p == null) return true;
        return p.val > low && p.val < high
                && valid(p.left, low, p.val) && valid(p.right, p.val, high);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
}
