/*
 * Another solution is to do an in-order traversal of the binary tree, and verify
 * that its in-order elements follow a strict monotonic increase order. During
 * the in-order traversal, we verify that the previous value is less than the
 * current node's value. The runtime complexity is also O(n)
 * O(n) runtime, O(n) stack space
 */
package _18_validate_BST_Recursion;

/**
 *
 * @author I300939
 */
public class ValidBSTInorder {
    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return isMonotonicIncreasing(root);
    }
    
    private boolean isMonotonicIncreasing(TreeNode p) {
        if (p == null) return true;
        if (isMonotonicIncreasing(p.left)) {
            if (prev != null && p.val <= prev.val) return false;
            prev = p;
            return isMonotonicIncreasing(p.right);
        }
        return false;
    }
}