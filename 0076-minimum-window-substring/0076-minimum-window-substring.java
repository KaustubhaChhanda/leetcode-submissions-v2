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
        int have = 0, need = tmap.size();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (tmap.containsKey(ch)) {
                smap.put(ch, smap.getOrDefault(ch, 0) + 1);

                if (tmap.get(ch).equals(smap.get(ch))) {
                    have++;
                }
            }

            while (left <= right && have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    substr = s.substring(left, right + 1);
                }

                char remove = s.charAt(left);

                if (tmap.containsKey(remove)) {
                    smap.put(remove, smap.get(remove) - 1);

                    if (smap.get(remove) < tmap.get(remove)) {
                        have--;
                    }

                    if (smap.get(remove) == 0) {
                        smap.remove(remove);
                    }
                }

                left++;
            }
        }

        return substr;
    }
}