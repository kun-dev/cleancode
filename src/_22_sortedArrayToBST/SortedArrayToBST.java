/*
 * Givin an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * This question is highly recursive in nature. Think of how binary serach works.
 * Solution: O(n) runtime, O(logn)stack space - Divide and conquer:
 * If you would have to choose an array element to be the root of a balanced BST,
 * which element would you pick? The root of a balanced BST should be the middle
 * element from the sorted array. There are two arrays left - the one on its left
 * and the one on its right. These two arrays are the sub-problems of the original
 * problem, sicne both of them are sorted. Furthermore, they are subtree of the
 * current node's left and right child.
 */
package _22_sortedArrayToBST;

/**
 *
 * @author I300939
 */
public class SortedArrayToBST {
    
    public TreeNode sortedArrayToBST(int[] arr) {
        return sortedArrayToBST(arr, 0, arr.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
}
