public class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 1, right = queries.length;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canZeroArray(nums, queries, mid)) {
                answer = mid;
                right = mid - 1; // try smaller k
            } else {
                left = mid + 1; // try bigger k
            }
        }

        return answer;
    }

    private boolean canZeroArray(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        long[] diff = new long[n + 2];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[l] += val;
            diff[r + 1] -= val;
        }

        long[] cap = new long[n];
        long curr = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i];
            cap[i] = curr;
            if (cap[i] < nums[i]) return false;
        }

        return true;
    }
}
