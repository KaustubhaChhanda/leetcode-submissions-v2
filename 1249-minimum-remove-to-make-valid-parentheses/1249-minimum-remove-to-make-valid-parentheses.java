class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                open--;
            }

            if (open < 0) {
                set.add(i);
                open = 0;
            }
        }

        int close = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (!set.contains(i)) {
                char ch = s.charAt(i);

                if (ch == ')') {
                    close++;
                } else if (ch == '(') {
                    close--;
                }

                if (close < 0) {
                    set.add(i);
                    close = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}