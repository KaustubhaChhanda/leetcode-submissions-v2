class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] memo = new Integer[cost.length];

        return Math.min(dfs(cost, 0, memo), dfs(cost, 1, memo));
    }

    private int dfs(int[] cost, int index, Integer[] memo) {
        if (index >= cost.length) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        return memo[index] = cost[index] + Math.min(dfs(cost, index + 1, memo), dfs(cost, index + 2, memo));
    }
}