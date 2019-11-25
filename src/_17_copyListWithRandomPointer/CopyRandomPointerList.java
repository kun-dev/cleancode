/*
 * A linked list is givin such that node contains an additional random pointer
 * that could point to any node in the list or null.
 * Return a deep copy of the list
 * We can modify the next node of the original node to point to its own copy.
 * A->A'->B->B'->C->C'->D->D'->E->E'->null
 * A'->B'->C'->D'->E'->null
 */
package _17_copyListWithRandomPointer;

/**
 *
 * @author I300939
 */
public class CopyRandomPointerList {
    
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        // generate new list combined with old list and copied list
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            RandomListNode next = p.next;
            p.next = copy;
            copy.next = next;
            p = next;
        }
        p = head;
        // set random pointer for newly copied list nodes
        while (p != null) {
            p.next.random = (p.random != null) ? p.random.next : null;
            p = p.next.next;
        }
        p = head;
        // split the old list and newly copied list
        RandomListNode headCopy = (p != null) ? p.next : null;
        while (p != null) {
            RandomListNode copy = p.next;
            p.next = copy.next;
            p = p.next;
            copy.next = (p != null) ? p.next : null;
        }
        return headCopy;
    }
}

class RandomListNode {
    String label;
    RandomListNode next;
    RandomListNode random;
    public RandomListNode() {}
    public RandomListNode(String label) {this.label = label;}
}
