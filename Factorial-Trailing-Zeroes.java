class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for (long base = 5; base <= n; base *= 5) {
            count += n / base;
        }
        return count;
    }
}
