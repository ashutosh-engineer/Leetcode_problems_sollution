class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProd = nums[0];
        int minSoFar = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Store prev max before updating
            int tempMax = maxSoFar;

            maxSoFar = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(tempMax * curr, minSoFar * curr));

            maxProd = Math.max(maxProd, maxSoFar);
        }

        return maxProd;
    }
}
