class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String w : words) {
            freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        int wordLength = words[0].length();
        int windowLength = words.length * wordLength;

        for (int left = 0; left <= s.length() - windowLength; left++) {
            Map<String, Integer> currMap = new HashMap<>();

            for (int temp = left;
                 temp < left + windowLength;
                 temp += wordLength) {

                String sub = s.substring(temp, temp + wordLength);
                currMap.put(sub, currMap.getOrDefault(sub, 0) + 1);
            }

            if (currMap.equals(freqMap)) {
                list.add(left);
            }
        }

        return list;
    }
}