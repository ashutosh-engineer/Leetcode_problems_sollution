class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int prev = nums[0];

        for (int i = 1; i + 1 < nums.length; i++) {
            // Skip duplicates: ignore current if equal to next
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            int cur = nums[i];
            int next = nums[i + 1];

            // Check hill: both neighbors smaller
            if (prev < cur && cur > next) {
                count++;
            }
            // Check valley: both neighbors larger
            else if (prev > cur && cur < next) {
                count++;
            }

            // Update prev to current unique value
            prev = cur;
        }

        return count;
    }
}
