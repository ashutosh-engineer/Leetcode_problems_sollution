public class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, bitmask = 0, maxLen = 0;

        for (int right = 0; right < n; right++) {
            // Shrink window until there's no overlap
            while ((bitmask & nums[right]) != 0) {
                bitmask ^= nums[left];
                left++;
            }

            bitmask |= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
