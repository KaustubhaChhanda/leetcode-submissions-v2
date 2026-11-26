class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                int height = heights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;

                max = Math.max(max, height * width);
            }

            stack.push(i);
        }   

        return max;
    }
}