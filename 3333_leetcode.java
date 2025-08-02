import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        List<Integer> runs = getConsecutiveLetters(word);
        long totalCombinations = 1;
        for (int len : runs) {
            totalCombinations = (totalCombinations * len) % MOD;
        }

        int n = runs.size();
        if (n >= k) {
            return (int) totalCombinations;
        }

        // dp[j] = number of original strings of length j using processed runs
        int[] dp = new int[k];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int len = runs.get(i);
            int[] newDp = new int[k];
            long windowSum = 0;
            for (int j = i; j < k; j++) {
                newDp[j] = (int)((newDp[j] + windowSum) % MOD);
                windowSum = (windowSum + dp[j]) % MOD;
                if (j >= len) {
                    windowSum = (windowSum - dp[j - len] + MOD) % MOD;
                }
            }
            dp = newDp;
        }

        long invalid = 0;
        for (int j = 0; j < k; j++) {
            invalid = (invalid + dp[j]) % MOD;
        }

        return (int)((totalCombinations - invalid + MOD) % MOD);
    }

    // Helper: breaks "word" into lengths of consecutive identical letters
    private List<Integer> getConsecutiveLetters(String word) {
        List<Integer> runs = new ArrayList<>();
        int n = word.length(), count = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                runs.add(count);
                count = 1;
            }
        }
        runs.add(count);
        return runs;
    }
}
