class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        long score = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            score += -(nums[left] * nums[left]) + nums[right] * nums[right];
            left++;
            right--;
        }

        if (left == right) {
            score += nums[left] * nums[right];
        }

        return score;
    }
}