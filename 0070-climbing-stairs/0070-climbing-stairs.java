class Solution {
    public int climbStairs(int n) {
        return dfs(0, n, new Integer[n]);
    }

    private int dfs(int curr, int n, Integer[] memo) {
        if (curr == n) {
            return 1;
        } else if (curr > n) {
            return 0;
        }

        if (memo[curr] != null) {
            return memo[curr];
        }

        return memo[curr] = dfs(curr + 1, n, memo) + dfs(curr + 2, n, memo);
    }
}