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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode otherHead = prev;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null && otherHead != null) {
            tail.next = head;
            head = head.next;
            tail = tail.next;
            tail.next = otherHead;
            otherHead = otherHead.next;
            tail = tail.next;
        }

        if (head != null) {
            tail.next = head;
        }

        if (otherHead != null) {
            tail.next = otherHead;
        }
    }
}