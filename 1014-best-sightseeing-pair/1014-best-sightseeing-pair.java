class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxLeft = values[0];
        int result = 0;

        for (int j = 1; j < values.length; j++) {
            result = Math.max(result, maxLeft + values[j] - j);
            maxLeft = Math.max(maxLeft, values[j] + j);
        }

        return result;
    }
}