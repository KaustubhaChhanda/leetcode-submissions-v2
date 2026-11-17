class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] twice = new int[nums.length * 2];

        for (int i = 0; i < twice.length; i++) {
            twice[i] = nums[i % nums.length];
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < twice.length; i++) {
            while (!stack.isEmpty() && twice[i] > twice[stack.peek()]) {
                twice[stack.pop()] = twice[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            twice[stack.pop()] = -1;
        }

        return Arrays.copyOfRange(twice, 0, nums.length);
    }
}