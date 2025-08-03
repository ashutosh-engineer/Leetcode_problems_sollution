class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0, sum = 0;

        for (int right = 0; right < n; ++right) {
            sum += fruits[right][1];

            // Shrink the window if it's not reachable within k steps
            while (left <= right && !canReach(fruits, left, right, startPos, k)) {
                sum -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, sum);
        }

        return maxFruits;
    }

    // Helper function to check if the window from left to right can be covered within k steps
    private boolean canReach(int[][] fruits, int left, int right, int start, int k) {
        int leftPos = fruits[left][0], rightPos = fruits[right][0];
        int option1 = Math.abs(start - leftPos) + (rightPos - leftPos); // go left first
        int option2 = Math.abs(start - rightPos) + (rightPos - leftPos); // go right first
        return Math.min(option1, option2) <= k;
    }
}
