class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (stack.isEmpty() || a > 0) {
                stack.push(a);
            } else {
                boolean exploded = false;

                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (Math.abs(a) > stack.peek()) {
                        stack.pop();
                    } else if (Math.abs(a) < stack.peek()) {
                        exploded = true;
                        break;
                    } else {
                        stack.pop();
                        exploded = true;
                        break;
                    }
                }

                if (!exploded) {
                    stack.push(a);
                }
            }
        }

        int[] arr = new int[stack.size()];

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }

        return arr;
    }
}