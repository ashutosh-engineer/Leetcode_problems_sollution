class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;         // No houses
        if (nums.length == 1) return nums[0];   // Only one house
        if (nums.length == 2) return Math.max(nums[0], nums[1]);  // Two houses

        int[] dp = new int[nums.length];
        dp[0] = nums[0];                          // Rob first house
        dp[1] = Math.max(nums[0], nums[1]);       // Rob max of first or second

        for (int i = 2; i < nums.length; i++) {
            // Rob current house + dp[i-2] or skip current house (dp[i-1])
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];               // Max loot
    }
}
