class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/+");
        System.out.println(Arrays.toString(arr));

        Stack<String> stack = new Stack<>();

        for (String s : arr) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }

        if (sb.isEmpty()) {
            sb.append('/');
        }

        return sb.toString();
    }
}