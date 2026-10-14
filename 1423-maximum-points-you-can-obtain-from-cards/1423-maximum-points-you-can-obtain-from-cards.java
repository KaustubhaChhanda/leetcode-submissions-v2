class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int window = n - k;
        int total = 0, curr = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            total += cardPoints[i];
        }

        if (window == 0) {
            return total;
        }

        for (int right = 0, left = 0; right < n; right++) {
            curr += cardPoints[right];

            if (right - left + 1 > window) {
                curr -= cardPoints[left++];
            }

            if (right - left + 1 == window) {
                min = Math.min(min, curr);
            }
        }

        return total - min;
    }
}