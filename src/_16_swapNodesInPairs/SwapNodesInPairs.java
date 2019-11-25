/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _16_swapNodesInPairs;

/**
 *
 * @author I300939
 */
public class SwapNodesInPairs {
    
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode prev = dummy;
        while (p != null && p.next != null) {
            ListNode q = p.next, r = p.next.next;
            prev.next = q;
            q.next = p;
            p.next = r;
            prev = p;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
}
