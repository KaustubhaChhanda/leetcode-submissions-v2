class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] twice = new int[nums.length * 2];

        for (int i = 0; i < twice.length; i++) {
            twice[i] = nums[i % nums.length];
        }

        int[] stack = new int[twice.length];
        int top = -1;

        for (int i = 0; i < twice.length; i++) {
            while (top != -1 && twice[i] > twice[stack[top]]) {
                twice[stack[top--]] = twice[i];
            }

            stack[++top] = i;
        }

        while (top != -1) {
            twice[stack[top--]] = -1;
        }

        return Arrays.copyOfRange(twice, 0, nums.length);
    }
}