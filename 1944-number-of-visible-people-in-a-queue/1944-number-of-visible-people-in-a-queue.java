class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
                ans[i]++;
            }

            if (!stack.isEmpty()) {
                ans[i]++;
            }

            stack.push(i);
        }

        return ans;
    }
}