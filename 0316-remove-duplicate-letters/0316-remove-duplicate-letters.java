class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(ch);
                set.add(ch);
                continue;
            }

            if (!set.contains(ch) && ch > stack.peek()) {
                stack.push(ch);
                set.add(ch);
                continue;
            }

            if (!stack.contains(ch) && ch < stack.peek()) {
                while (!stack.isEmpty() && ch < stack.peek() && map.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }

                stack.push(ch);
                set.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}