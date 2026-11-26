class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        if (n == 1) {
            return heights[0];
        }

        int[] stack = new int[n + 1];
        int top = -1;
        int max = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (top != -1 && heights[stack[top]] > currHeight) {
                int height = heights[stack[top--]];
                int width = (top == -1) ? i : i - stack[top] - 1;

                max = Math.max(max, height * width);
            }

            stack[++top] = i;
        }   

        return max;
    }
}