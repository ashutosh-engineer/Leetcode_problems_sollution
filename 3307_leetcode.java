class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        // Compute total length: 2^n ≥ k (not directly computed but used via shifting logic)
        int totalOps = (int) Math.ceil(Math.log(k) / Math.log(2));
        if (totalOps > n) {
            totalOps = n; // in case k smaller than 2^n
        }

        // Backward simulation:
        int shift = 0;
        for (int i = totalOps - 1; i >= 0; i--) {
            long half = 1L << i;
            if (k > half) {
                k -= half;
                shift += operations[i];
            }
        }

        return (char) ('a' + (shift % 26));
    }
}
