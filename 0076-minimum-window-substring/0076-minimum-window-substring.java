class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        String substr = "";

        int left = 0;
        Map<Character, Integer> smap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);

            while (left <= right && isValid(smap, tmap)) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    substr = s.substring(left, right + 1);
                }

                char remove = s.charAt(left);

                if (smap.get(remove) > 1) {
                    smap.put(remove, smap.get(remove) - 1);
                } else {
                    smap.remove(remove);
                }

                left++;
            }
        }

        return substr;
    }

    private boolean isValid(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        for (char ch : tmap.keySet()) {
            if (!smap.containsKey(ch) || smap.get(ch) < tmap.get(ch)) {
                return false;
            }
        }

        return true;
    }
}