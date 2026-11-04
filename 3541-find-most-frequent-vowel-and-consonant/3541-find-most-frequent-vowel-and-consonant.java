class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxVows = 0;
        int maxCons = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                maxVows = Math.max(maxVows, freq[ch - 'a']);
            } else {
                maxCons = Math.max(maxCons, freq[ch - 'a']);
            }
        }

        return maxVows + maxCons;
    }
}