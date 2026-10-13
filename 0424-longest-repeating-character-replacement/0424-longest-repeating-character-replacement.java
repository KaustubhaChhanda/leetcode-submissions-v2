class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0, left = 0, maxFreq = 0;
        int[] freq = new int[26];

        for (int right = 0; right < s.length(); right++) {
            int f = ++freq[s.charAt(right) - 'A'];
            maxFreq = Math.max(maxFreq, f);

            if (((right - left + 1) - maxFreq) <= k) {
                max = Math.max(max, right - left + 1);
            } else {
                while (left <= right && ((right - left + 1) - maxFreq) > k) {
                    maxFreq = Math.max(maxFreq, --freq[s.charAt(left++) - 'A']);
                }
            }
        }

        return max;        
    }
}