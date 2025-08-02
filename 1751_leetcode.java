import java.util.*;

class Solution {
    public long maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[1])); // sort by end day
        
        int[] start = new int[n];
        for (int i = 0; i < n; i++) start[i] = events[i][0];
        
        // Precompute next index for each event using binary search
        int[] nextIdx = new int[n];
        for (int i = 0; i < n; i++) {
            int end = events[i][1];
            int l = i + 1, r = n;
            while (l < r) {
                int m = (l + r) / 2;
                if (start[m] > end) r = m;
                else l = m + 1;
            }
            nextIdx[i] = l;
        }

        // dp[j][i]: max sum using at most j events from i...n-1
        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            for (int i = n - 1; i >= 0; i--) {
                long skip = dp[j][i + 1];
                long take = events[i][2] + (nextIdx[i] < n ? dp[j - 1][ nextIdx[i] ] : 0L);
                dp[j][i] = Math.max(skip, take);
            }
        }

        return dp[k][0];
    }
}
