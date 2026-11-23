class Solution {
    public boolean find132pattern(int[] nums) {
        int[][] stack = new int[nums.length][2];
        int top = -1;
        int currMin = nums[0];

        for (int num : nums) {
            while (top != -1 && num >= stack[top][0]) {
                top--;
            }

            if (top != -1 && num < stack[top][0] && stack[top][1] < num) {
                return true;
            }

            stack[++top] = new int[]{num, currMin};
            currMin = Math.min(currMin, num);
        }

        return false;
    }
}