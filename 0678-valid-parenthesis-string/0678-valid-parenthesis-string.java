class Solution {
    public boolean checkValidString(String s) {
        return dfs(s, 0, 0, new Boolean[s.length()][s.length()]);
    }

    private boolean dfs(String s, int index, int val, Boolean[][] memo) {
        if (index == s.length()) {
            return val == 0;
        }

        if (memo[index][val] != null) {
            return memo[index][val];
        }

        char ch = s.charAt(index);

        if (ch == '(') {
            return memo[index][val] = dfs(s, index + 1, val + 1, memo);
        } else if (ch == ')') {
            if (val == 0) {
                return false; 
            } else {
                return memo[index][val] = dfs(s, index + 1, val - 1, memo);
            }
        } else {
            return memo[index][val] = dfs(s, index + 1, val, memo) || dfs(s, index + 1, val + 1, memo) || ((val != 0) ? dfs(s, index + 1, val - 1, memo) : false);
        }
    }
}