class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {
            while (top != -1 && heights[i] > heights[stack[top]]) {
                top--;
                ans[i]++;
            }

            if (top != -1) {
                ans[i]++;
            }

            stack[++top] = i;
        }

        return ans;
    }
}