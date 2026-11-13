class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        char[] stack = new char[s.length()];
        int top = -1;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (top == -1) {
                stack[++top] = ch;
                set.add(ch);
                continue;
            }

            if (!set.contains(ch) && ch > stack[top]) {
                stack[++top] = ch;
                set.add(ch);
                continue;
            }

            if (!set.contains(ch) && ch < stack[top]) {
                while (top >= 0 && ch < stack[top] && map.get(stack[top]) > i) {
                    set.remove(stack[top--]);
                }

                stack[++top] = ch;
                set.add(ch);
            }
        }

        return new String(stack, 0, top + 1);
    }
}