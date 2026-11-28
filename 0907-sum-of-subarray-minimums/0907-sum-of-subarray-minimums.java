class Solution {
    private final long MOD =  1_000_000_007L;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long[] left = new long[n];
        long[] right = new long[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top != -1 && arr[stack[top]] >= arr[i]) {
                top--;
            }

            int prevIdx = top == -1 ? -1 : stack[top];
            left[i] = i - prevIdx;

            stack[++top] = i;;
        }

        top = -1;

        for (int i = n - 1; i >= 0; i--) {
            while (top != -1 && arr[stack[top]] > arr[i]) {
                top--;
            }

            int nextIdx = top == -1 ? n : stack[top];
            right[i] = nextIdx - i;

            stack[++top] = i;;
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += ((long) arr[i] * left[i] % MOD) * right[i] % MOD;
        }

        return (int) (sum % MOD);
    }
}