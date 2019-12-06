/*
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
package _99_interviewQ;

/**
 *
 * @author I300939
 */
public class LinkedListKthToLast {
    public Node kthToLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}

class Node {
    int val;
    Node next;
}
