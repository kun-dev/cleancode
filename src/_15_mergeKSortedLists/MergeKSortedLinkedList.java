/*
 * Merge k sorted linked lists and return it as one sorted list.
 */
package _15_mergeKSortedLists;

import java.util.List;

/**
 *
 * @author I300939
 */
public class MergeKSortedLinkedList {
    
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) return null;
        int end = lists.size() - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                lists.set(begin, merge2Lists(lists.get(begin), lists.get(end)));
                begin ++;
                end --;
            }
        }
        return lists.get(0);
    }
    
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
       ListNode dummyHead = new ListNode();
       ListNode p = dummyHead;
       while (l1 != null && l2 != null) {
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
