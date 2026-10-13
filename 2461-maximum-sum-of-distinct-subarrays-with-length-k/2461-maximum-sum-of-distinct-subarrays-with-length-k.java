class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long maxSum = 0, sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if (right >= k - 1) {
                if (map.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }

                int leftEl = nums[right - k + 1];

                if (map.get(leftEl) > 1) {
                    map.put(leftEl, map.get(leftEl) - 1);
                } else {
                    map.remove(leftEl);
                }

                sum -= leftEl;
            }
        }

        return maxSum;
    }
}