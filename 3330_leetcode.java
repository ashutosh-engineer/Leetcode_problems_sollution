class Solution {
    public int possibleStringCount(String word) {
        List<Integer> groups = new ArrayList<>();
        int n = word.length();
        int count = 1;

        // Group consecutive characters
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count); // Add the last group

        int total = 1; // Base case: original string unchanged

        for (int len : groups) {
            if (len > 1) {
                total += len - 1; // You can reduce this group in (len - 1) ways
                break; // Only one group can be reduced
            }
        }

        return total;
    }
}
