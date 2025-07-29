class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] last = new int[32]; // track last seen index of each bit

        for (int i = n - 1; i >= 0; i--) {
            // update the last seen position of each bit
            for (int b = 0; b < 32; b++) {
                if (((nums[i] >> b) & 1) == 1) {
                    last[b] = i;
                }
            }

            int maxIndex = i;
            for (int b = 0; b < 32; b++) {
                maxIndex = Math.max(maxIndex, last[b]);
            }
            ans[i] = maxIndex - i + 1;
        }

        return ans;
    }
}
