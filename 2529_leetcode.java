class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;

        // Binary search to find first positive
        int pos = firstGreaterThanZero(nums);

        // Binary search to find first zero (which gives neg count)
        int neg = firstZero(nums);

        return Math.max(pos, neg);
    }

    // Find first index where nums[i] > 0
    private int firstGreaterThanZero(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums.length - left;
    }

    // Find first index where nums[i] >= 0, so negatives end before this
    private int firstZero(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // count of negative numbers
    }
}
