class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            int val = ch - 'A' + 1;  // A=1, B=2, ..., Z=26
            result = result * 26 + val;
        }
        return result;
    }
}
