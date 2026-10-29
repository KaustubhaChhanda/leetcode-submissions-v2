class Solution {
    public String minWindow(String s, String t) {
        int[] tmap = new int[52];

        for (char ch : t.toCharArray()) {
            tmap[getIndex(ch)]++;
        }

        int minLen = Integer.MAX_VALUE;
        String substr = "";

        int left = 0;
        int[] smap = new int[52];
        int have = 0, need = 0;

        for (int count : tmap) {
            if (count > 0) {
                need++;
            }
        }

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            int idx = getIndex(ch);

            if (tmap[idx] > 0) {
                smap[idx]++;

                if (tmap[idx] == smap[idx]) {
                    have++;
                }
            }

            while (left <= right && have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    substr = s.substring(left, right + 1);
                }

                char remove = s.charAt(left);
                int removeIdx = getIndex(remove);

                if (tmap[removeIdx] > 0) {
                    smap[removeIdx]--;

                    if (smap[removeIdx] < tmap[removeIdx]) {
                        have--;
                    }
                }

                left++;
            }
        }

        return substr;
    }

    private int getIndex(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        }
        return ch - 'A' + 26;
    }
}