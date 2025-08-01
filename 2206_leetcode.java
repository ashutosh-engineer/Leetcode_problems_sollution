public class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];  // since 1 <= nums[i] <= 500

        for (int num : nums) {
            freq[num]++;
        }

        for (int count : freq) {
            if (count % 2 != 0) return false;
        }

        return true;
    }
}
