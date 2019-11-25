/*
 * Givin two linked lists representing two non-negative numbers. The digits are
 * stored in reverse order and each of their nodes contains a single digit. Add
 * the two numbers and return it as a linked list.
 * Keep track of the carry using a variable and simulate digits digits by digits
 * sum from the head of list, which contains the least-significant digit.
 */
package _14_addTwoNumbers;

/**
 *
 * @author I300939
 */
public class AddTwoNumber {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int digit = carry + x + y;
            carry = digit / 10;
            curr.next = new ListNode(digit % 10);
            curr = curr.next;
        }
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
}
