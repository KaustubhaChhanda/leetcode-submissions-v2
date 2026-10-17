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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode tail = head;

        while (tail != null) {
            tail = tail.next;
            length++;
        }

        return convert(head, length);
    }

    private TreeNode convert(ListNode head, int length) {
        if (length <= 0) {
            return null;
        }

        int mid = (length - 1) / 2;
        ListNode tail = head;

        for (int i = 0; i < mid; i++) {
            tail = tail.next;
        }

        TreeNode node = new TreeNode(tail.val);
        node.left = convert(head, mid);
        node.right = convert(tail.next, length - mid - 1);

        return node;
    }
}