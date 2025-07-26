// You are given an integer array nums.

// You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:

// All elements in the subarray are unique.
// The sum of the elements in the subarray is maximized.
// Return the maximum sum of such a subarray.

 

// Example 1:

// Input: nums = [1,2,3,4,5]

// Output: 15

// Explanation:

// Select the entire array without deleting any element to obtain the maximum sum.

// Example 2:

// Input: nums = [1,1,0,1,1]

// Output: 1

// Explanation:

// Delete the element nums[0] == 1, nums[1] == 1, nums[2] == 0, and nums[3] == 1. Select the entire array [1] to obtain the maximum sum.

// Example 3:

// Input: nums = [1,2,-1,-2,1,0,-1]

// Output: 3

// Explanation:

// Delete the elements nums[2] == -1 and nums[3] == -2, and select the subarray [2, 1] from [1, 2, 1, 0, -1] to obtain the maximum sum.

 

// Constraints:

// 1 <= nums.length <= 100
// -100 <= nums[i] <= 100

import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        // Find the maximum value in the array
        int mx = Arrays.stream(nums).max().getAsInt();

        // If all values are <= 0, the best non-empty subarray is the largest single element
        if (mx <= 0) {
            return mx;
        }

        // Otherwise, sum all distinct positive numbers
        // Using a boolean array to track uniqueness for efficiency
        boolean[] seen = new boolean[201]; // since nums[i] ranges -100 to 100
        int ans = 0;

        for (int x : nums) {
            if (x > 0 && !seen[x + 100]) {
                ans += x;
                seen[x + 100] = true;
            }
        }

        return ans;
    }
}
