class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;

        for (int i = 0; i < temperatures.length; i++) {
            while (top != -1 && temperatures[i] > temperatures[stack[top]]) {
                temperatures[stack[top]] = i - stack[top--];
            }

            stack[++top] = i;
        }

        while (top != -1) {
            temperatures[stack[top--]] = 0;
        }

        return temperatures;
    }
}