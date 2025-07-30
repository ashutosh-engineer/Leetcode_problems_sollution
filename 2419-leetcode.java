class Solution {
    public int longestSubarray(int[] nums) {
        int mx = 0;
        // Find the maximum value
        for (int v : nums) {
            mx = Math.max(mx, v);
        }
        
        int longest = 0;
        int current = 0;
        // Scan to find longest run of mx
        for (int v : nums) {
            if (v == mx) {
                current++;
                longest = Math.max(longest, current);
            } else {
                current = 0;
            }
        }
        return longest;
    }
}
