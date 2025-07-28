class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum must be to the right of mid
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                // Minimum is at mid or to the left
                high = mid;
            } else {
                // nums[mid] == nums[high], can't decide the side → safely reduce search space
                high--;
            }
        }

        return nums[low];
    }
}
