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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tail = list1;

        for (int i = 0; i < a - 1; i++) {
            tail = tail.next;
        }

        ListNode beforeA = tail;

        for (int i = 0; i < b - a + 2; i++) {
            tail = tail.next;
        }

        ListNode afterB = tail;
        tail = list2;

        while (tail.next != null) {
            tail = tail.next;
        }

        beforeA.next = list2;
        tail.next = afterB;

        return list1;
    }
}