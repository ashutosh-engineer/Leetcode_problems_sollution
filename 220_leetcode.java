import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];

            // Find the smallest number >= num - valueDiff
            Long ceil = set.ceiling(num - valueDiff);
            if (ceil != null && ceil <= num + valueDiff) {
                return true;
            }

            set.add(num);

            // Maintain window of size indexDiff
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}
