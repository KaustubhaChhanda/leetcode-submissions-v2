
class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] memo = new Boolean[s.length()][s.length() + 1];
        return dfs(s, 0, 0, memo);
    }

    private boolean dfs(String s, int i, int open, Boolean[][] memo) {
        if (open < 0) return false;

        if (i == s.length()) {
            return open == 0;
        }

        if (memo[i][open] != null) {
            return memo[i][open];
        }

        char ch = s.charAt(i);
        boolean ans;

        if (ch == '(') {
            ans = dfs(s, i + 1, open + 1, memo);
        } 
        else if (ch == ')') {
            ans = dfs(s, i + 1, open - 1, memo);
        } 
        else {
            ans = dfs(s, i + 1, open, memo) || dfs(s, i + 1, open + 1, memo) || dfs(s, i + 1, open - 1, memo);
        }

        return memo[i][open] = ans;
    }
}