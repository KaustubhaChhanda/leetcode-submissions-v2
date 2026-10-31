class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int min = max;

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            int temp = max;

            max = Math.max(x, Math.max(x * temp, x * min));
            min = Math.min(x, Math.min(x * temp, x * min));

            ans = Math.max(ans, max);
        }

        return ans;
    }
}