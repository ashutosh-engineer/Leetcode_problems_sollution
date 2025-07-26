//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
/You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            if (seen.containsKey(needed)) {
                return new int[] { seen.get(needed), i };
            }
            seen.put(nums[i], i);
        }

        // Should never reach here as problem guarantees one solution
        return new int[0];
    }
}
