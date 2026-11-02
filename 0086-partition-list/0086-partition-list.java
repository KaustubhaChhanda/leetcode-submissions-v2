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
        ListNode less = new ListNode(0);
        ListNode greater = new ListNode(0);

        ListNode l = less;
        ListNode g = greater;

        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                g.next = head;
                g = g.next;
            }

            head = head.next;
        }

        g.next = null;
        l.next = greater.next;

        return less.next;
    }
}