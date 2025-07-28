class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If middle element is greater than the rightmost, minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Else, minimum is in the left half (including mid)
            else {
                right = mid;
            }
        }

        // At the end, left == right and points to the smallest element
        return nums[left];
    }
}
