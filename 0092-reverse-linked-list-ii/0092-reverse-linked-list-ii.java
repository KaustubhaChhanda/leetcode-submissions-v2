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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode tail = dummy;

        for (int i = 0; i < left - 1; i++) {
            tail = tail.next;
        }

        ListNode firstEnd = tail;
        ListNode secondStart =  tail.next;

        ListNode prev = null;
        ListNode curr = tail.next;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        firstEnd.next = prev;
        secondStart.next = curr;

        return dummy.next;
    }
}