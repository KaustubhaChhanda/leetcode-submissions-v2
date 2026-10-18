class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gIdx = 0, sIdx = 0;

        while (gIdx < g.length && sIdx < s.length) {
            if (s[sIdx] >= g[gIdx]) {
                count++;
                sIdx++;
                gIdx++;
            } else {
                sIdx++;
            }
        }

        return count;
    }
}