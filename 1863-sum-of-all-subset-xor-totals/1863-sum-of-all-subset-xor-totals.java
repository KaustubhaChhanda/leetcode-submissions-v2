class Solution {
    int total = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        
        return total;
    }

    private void dfs(int[] nums, int index, int xor) {
        if (index == nums.length) {
            total += xor;
            return;
        }

        dfs(nums, index + 1, xor);
        dfs(nums, index + 1, xor ^ nums[index]);
    }
}