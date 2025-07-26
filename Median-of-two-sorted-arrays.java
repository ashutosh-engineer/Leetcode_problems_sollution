// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) 
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = totalLeft - i;

            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else {
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays not valid for finding median.");
    }
}
