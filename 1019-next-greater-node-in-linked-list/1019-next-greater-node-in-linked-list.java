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
    public int[] nextLargerNodes(ListNode head) {
        ListNode tail = head;
        int len = 0;

        while (tail != null) {
            tail = tail.next;
            len++;
        }

        int[] ans = new int[len];
        int index = 0;
        tail = head;

        while (tail != null) {
            ans[index++] = tail.val;
            tail = tail.next;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && ans[i] > ans[stack.peek()]) {
                ans[stack.pop()] = ans[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }

        return ans;

    }
}