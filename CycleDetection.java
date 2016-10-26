
public class CycleDetection {

    /*
    Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
    https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
    */

    boolean hasCycle(Node head) {

        if(head == null){
            return false;
        }

        Node n1 = head;
        Node n2 = head;

        do {
            n1 = n1.next;
            n2 = n2.next != null? n2.next.next : null;
        } while(n2 != null && n2 != n1);

        return n2 == n1;
    }

    private class Node {
        int data;
        Node next;
    }

}
