class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }

        char[] stack = new char[num.length()];
        int top = -1;

        for (char ch : num.toCharArray()) {
            while (top != -1 && k > 0 && ch < stack[top]) {
                top--;
                k--;
            }

            stack[++top] = ch;
        }

        while (k != 0) {
            top--;
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (top != -1) {
            sb.insert(0, stack[top--]);
        }

        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}