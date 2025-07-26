class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        int[] dp = new int[n];

        // Precompute isPal[i][j]
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 2 || isPal[start + 1][end - 1])) {
                    isPal[start][end] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0; // no cut needed
            } else {
                dp[i] = i; // maximum i cuts possible
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}
