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
        ListNode greatOrEqual = new ListNode(0);

        ListNode t1 = less;
        ListNode t2 = greatOrEqual;
        ListNode t3 = head;

        while (t3 != null) {
            if (t3.val < x) {
                t1.next = t3;
                t1 = t1.next;
            } else {
                t2.next = t3;
                t2 = t2.next;
            }

            ListNode next = t3.next;
            t3.next = null;
            t3 = next;
        }

        t1.next = greatOrEqual.next;

        return less.next;
    }
}