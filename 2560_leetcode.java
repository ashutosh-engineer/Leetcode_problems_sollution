public class Solution {
    public int minCapability(int[] nums, int k) {
        int low = 0, high = (int)1e9;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canRobAtLeastK(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canRobAtLeastK(int[] nums, int k, int maxCap) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= maxCap) {
                count++;
                i += 2;  // skip adjacent house
            } else {
                i++;
            }
        }

        return count >= k;
    }
}
