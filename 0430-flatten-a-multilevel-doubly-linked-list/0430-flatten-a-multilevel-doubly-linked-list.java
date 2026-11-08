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
        flattenDFS(head);
        return head;
    }

    private Node flattenDFS(Node node) {
        Node curr = node;
        Node last = node;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node child = curr.child;

                Node childTail = flattenDFS(child);

                curr.next = child;
                child.prev = curr;
                curr.child = null;

                childTail.next = next;

                if (next != null) {
                    next.prev = childTail;
                }

                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }
}