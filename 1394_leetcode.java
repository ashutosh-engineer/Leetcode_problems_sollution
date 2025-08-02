class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501]; // Because 1 <= arr[i] <= 500

        // Count frequencies
        for (int num : arr) {
            freq[num]++;
        }

        // Find largest lucky number
        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) {
                return i;
            }
        }

        return -1; // No lucky number
    }
}
