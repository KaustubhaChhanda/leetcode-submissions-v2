/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        List<ListNode> list = new ArrayList<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;

        while (tail.next != null) {
            if (tail.next.val >= x) {
                ListNode node = tail.next;
                list.add(node);
                tail.next = node.next;
                node.next = null;
            } else {
                tail = tail.next;
            }
        }

        tail = dummy;

        while (tail.next != null) {
            tail = tail.next;
        }

        for (ListNode node : list) {
            tail.next = node;
            tail = node;
        }

        return dummy.next;
    }
}