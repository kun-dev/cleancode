/*
 * Merge two sorted linked lists and return it as a new list. The new list should
 * be made by splicing together the nodes of the first two lists.
 * We insert a dummy head before the new list so we don't have to deal with spcial
 * cases such as initializing the new list's head. Then the new list's head could
 * just easily be returned as dummy head's next
 */
package _13_mergeTwoSortedLinkedList;

/**
 *
 * @author I300939
 */
public class MergeTwoSortedLinkedList {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        while(l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
}
