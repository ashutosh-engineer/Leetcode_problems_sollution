class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            // If previous mapping is inconsistent
            if (sMap[sc] != tMap[tc]) return false;

            // Mark both characters as seen at position i + 1 (to avoid confusion with default 0)
            sMap[sc] = i + 1;
            tMap[tc] = i + 1;
        }

        return true;
    }
}
