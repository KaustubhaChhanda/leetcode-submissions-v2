class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] a = new int[mid - low + 1];
        int[] b = new int[high - mid];

        int aIdx = 0;
        for (int i = low; i <= mid; i++) {
            a[aIdx++] = nums[i];
        }

        int bIdx = 0;
        for (int i = mid + 1; i <= high; i++) {
            b[bIdx++] = nums[i];
        }

        int index = low;
        aIdx = 0;
        bIdx = 0;

        while (aIdx < a.length && bIdx < b.length) {
            if (a[aIdx] < b[bIdx]) {
                nums[index++] = a[aIdx++];
            } else {
                nums[index++] = b[bIdx++];
            }
        }

        while (aIdx < a.length) {
            nums[index++] = a[aIdx++];
        }

        while (bIdx < b.length) {
            nums[index++] = b[bIdx++];
        }
    }
}