class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] sorted = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                sorted[k++] = nums1[i++];
            } else {
                sorted[k++] = nums2[j++];
            }
        }

        while (i < m) {
            sorted[k++] = nums1[i++];
        }

        while (j < n) {
            sorted[k++] = nums2[j++];
        }

        if ((m + n) % 2 == 0) {
            int a = (m + n) / 2;
            int b = a - 1;

            return (sorted[a] + sorted[b]) / (double) 2;
        } else {
            return (double) sorted[(m + n) / 2];
        }
    }
}