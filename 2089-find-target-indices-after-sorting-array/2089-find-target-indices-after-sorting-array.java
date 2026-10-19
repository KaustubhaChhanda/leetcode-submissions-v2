class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int offset = 0, freq = 0;

        for (int num : nums) {
            if (num < target) {
                offset++;
            } else if (num == target) {
                freq++;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = offset; i < offset + freq; i++) {
            list.add(i);
        }

        return list;
    }
}