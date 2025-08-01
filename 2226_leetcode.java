public class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = (int)1e7;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canAllocate(candies, k, mid)) {
                result = mid;   // mid is valid, try higher
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean canAllocate(int[] candies, long k, int perChild) {
        long count = 0;
        for (int c : candies) {
            count += c / perChild;
        }
        return count >= k;
    }
}
