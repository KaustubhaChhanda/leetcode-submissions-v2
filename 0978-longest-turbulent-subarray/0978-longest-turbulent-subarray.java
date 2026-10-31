class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        int prev = 0;
        int max = 1, curr = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (prev == 0) {
                if (arr[i] < arr[i + 1]) {
                    curr++;
                    prev = -1;
                    max = Math.max(max, curr);
                } else if (arr[i] > arr[i + 1]) {
                    curr++;
                    prev = 1;
                    max = Math.max(max, curr);
                } else {
                    curr = 1;
                    prev = 0;
                }
            } else if (prev == 1) {
                if (arr[i] < arr[i + 1]) {
                    curr++;
                    prev = -1;
                    max = Math.max(max, curr);
                } else if (arr[i] > arr[i + 1]) {
                    curr = 2;
                    prev = 1;
                    max = Math.max(max, curr);
                } else {
                    curr = 1;
                    prev = 0;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    curr++;
                    prev = 1;
                    max = Math.max(max, curr);
                } else if (arr[i] < arr[i + 1]) {
                    curr = 2;
                    prev = -1;
                    max = Math.max(max, curr);
                } else {
                    curr = 1;
                    prev = 0;
                }
            }
        }

        return max;
    }
}