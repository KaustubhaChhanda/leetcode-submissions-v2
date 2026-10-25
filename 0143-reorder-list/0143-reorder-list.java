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
        List<Integer> list = new ArrayList<>();
        ListNode tail = head;

        while (tail != null) {
            list.add(tail.val);
            tail = tail.next;
        }

        int left = 0, right = list.size() - 1;
        tail = head;
        boolean toggle = true;

        while (tail != null) {
            if (toggle) {
                tail.val = list.get(left++);
            } else {
                tail.val = list.get(right--);
            }

            toggle = !toggle;
            tail = tail.next;
        }
    }
}