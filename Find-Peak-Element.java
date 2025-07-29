class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare middle with its right neighbor
            if (nums[mid] > nums[mid + 1]) {
                // You're in the decreasing part; peak is to the left (including mid)
                right = mid;
            } else {
                // You're in the increasing part; peak is to the right
                left = mid + 1;
            }
        }

        // left == right is the peak index
        return left;
    }
}
