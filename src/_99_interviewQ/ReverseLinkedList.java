/*
 * Revert a Linked List
 * Input 1->2->3->4->NULL
 * Output 4->3->2->1->NULL
 */
package _99_interviewQ;

/**
 *
 * @author I300939
 */
public class ReverseLinkedList {
    
    Node head;
    
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        Node current = head;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
    
    void printList(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main(String[] args) {
        ReverseLinkedList me = new ReverseLinkedList();
        me.head = new Node(1);
        me.head.next = new Node(2);
        me.head.next.next = new Node(3);
        me.head.next.next.next = new Node(4);
        me.head = me.reverse(me.head);
        me.printList(me.head);
    }
    
}
