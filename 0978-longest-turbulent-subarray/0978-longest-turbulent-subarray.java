class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max = 1, curr = 1, prev = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int sign = Integer.compare(arr[i], arr[i + 1]);

            if (sign == 0) {
                curr = 1;
            } else if (sign == prev) {
                curr = 2;
            } else {
                curr++;
            }

            if (sign != 0) {
                prev = sign;
            } else {
                prev = 0;
            }

            max = Math.max(max, curr);
        }

        return max;
    }
}