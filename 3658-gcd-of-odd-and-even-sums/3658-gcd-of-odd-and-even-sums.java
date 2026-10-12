class Solution {
    public int gcdOfOddEvenSums(int n) {
        return gcd(n * (n + 1), n * n);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}