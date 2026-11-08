/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        return flattenList(head, null);
    }

    private Node flattenList(Node head, Node prev) {
        if (head == null) {
            return head;
        }

        head.prev = prev;

        Node next = head.next;
        Node tail  = head;
        tail.next = flattenList(tail.child, tail);
        tail = head;
        
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = flattenList(next, tail);
        head.child = null;
        return head;
    }
}