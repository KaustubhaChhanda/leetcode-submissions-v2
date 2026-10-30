class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        int far = 0, near = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[near], map.get(nums[near]) -1);
                
                if (map.get(nums[near]) == 0) {
                    map.remove(nums[near]);
                    near++;
                }

                far = near;
            }

            while (map.get(nums[near]) > 1) {
                map.put(nums[near], map.get(nums[near]) - 1);
                near++;
            }

            if (map.size() == k) {
                count += near - far + 1;
            }
        }

        return count;
    }
}