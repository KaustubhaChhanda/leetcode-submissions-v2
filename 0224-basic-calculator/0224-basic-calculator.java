class Solution {
    int index = 0;

    public int calculate(String s) {
        return eval(s);
    }

    private int eval(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char prevOp = '+';

        while (index < s.length()) {
            char ch = s.charAt(index++);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (ch == '(') {
                num = eval(s);
            }

            if (ch == ')' || index == s.length() ||
                (!Character.isDigit(ch) && ch != ' ' && ch != '(')) {

                if (prevOp == '+') {
                    stack.push(num);
                } else if (prevOp == '-') {
                    stack.push(-num);
                }

                num = 0;
                prevOp = ch;
            }

            if (ch == ')') {
                break;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}