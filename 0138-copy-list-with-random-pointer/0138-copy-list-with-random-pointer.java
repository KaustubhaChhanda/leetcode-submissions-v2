/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node cHead = new Node(head.val);

        Node t1 = head;
        Node t2 = cHead;

        map.put(t1, t2);

        while (t1.next != null) {
            Node node = new Node(t1.next.val);
            t2.next = node;

            t1 = t1.next;
            t2 = t2.next;

            map.put(t1, t2);
        }

        t1 = head;
        t2 = cHead;

        while (t1 != null) {
            t2.random = map.get(t1.random);
            
            t1 = t1.next;
            t2 = t2.next;
        }

        return cHead;
    }
}