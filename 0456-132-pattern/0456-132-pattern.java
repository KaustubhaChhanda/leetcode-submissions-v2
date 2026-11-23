class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int currMin = nums[0];

        for (int num : nums) {
            while (!stack.isEmpty() && num >= stack.peek()[0]) {
                stack.pop();    
            }

            if (!stack.isEmpty() && num < stack.peek()[0] && stack.peek()[1] < num) {
                return true;
            }

            stack.push(new int[]{num, currMin});
            currMin = Math.min(currMin, num);
        }

        return false;
    }
}