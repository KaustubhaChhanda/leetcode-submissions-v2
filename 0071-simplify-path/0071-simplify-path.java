class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/+");
        String[] stack = new String[arr.length];
        int top = -1;

        for (String s : arr) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (top >= 0) {
                    top--;
                }
            } else {
                stack[++top] = s;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= top; i++) {
            sb.append("/");
            sb.append(stack[i]);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}