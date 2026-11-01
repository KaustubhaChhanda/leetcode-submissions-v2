class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int prevMax = values[0];
        int maxScore = 0;

        for (int i = 1; i < values.length; i++) {
            maxScore = Math.max(maxScore, prevMax + values[i] - i);
            prevMax = Math.max(prevMax, values[i] + i);
        }

        return maxScore;
    }
}