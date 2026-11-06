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
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tail = head;

        while (tail != null) {
            list.add(tail);
            tail = tail.next;
        }

        Collections.sort(list, (a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        tail = dummy;

        for (int i = 0; i < list.size(); i++) {
            tail.next = list.get(i);
            tail = tail.next;
        }

        tail.next = null;

        return dummy.next;
    }
}