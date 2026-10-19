class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int count = 0, left = 0, prod = 1;

        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];

            while (left <= right && prod >= k) {
                prod /= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }
}