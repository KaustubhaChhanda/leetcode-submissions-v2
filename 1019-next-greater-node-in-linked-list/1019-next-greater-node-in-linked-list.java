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

        int[] stack = new int[len];
        int top = -1;

        for (int i = 0; i < len; i++) {
            while (top != -1 && ans[i] > ans[stack[top]]) {
                ans[stack[top--]] = ans[i];
            }

            stack[++top] = i;
        }

        while (top != -1) {
            ans[stack[top--]] = 0;
        }

        return ans;
    }
}