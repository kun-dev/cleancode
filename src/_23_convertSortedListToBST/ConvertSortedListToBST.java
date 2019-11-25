/*
 * Givin a singly linked list where elements are sorted in ascending order, convert
 * it to a height balanced BST.
 * Bottom-up recursion: O(n) runtime, O(logn) stack space.
 * We no longer create nodes in the tree using the top-down approach. We create
 * nodes bottom-up, and assign them to its parents. The buttom-up apprach enable
 * us to access the list in its order while creating node.
 */
package _23_convertSortedListToBST;

/**
 *
 * @author I300939
 */
public class ConvertSortedListToBST {
    private ListNode list;
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode leftChild = sortedListToBST(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBST(mid + 1, end);
        return parent;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n ++;
        }
        list = head;
        return sortedListToBST(0, n - 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
}

class ListNode {
    int val;
    ListNode next;
}
