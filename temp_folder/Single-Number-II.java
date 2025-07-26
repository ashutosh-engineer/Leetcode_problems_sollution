class Solution {
    public int singleNumber(int[] nums) {
        int[] bitCount = new int[32];  // To store count of each bit

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    bitCount[i]++;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % 3 != 0) {
                result |= (1 << i);
            }
        }

        // Handle negative numbers
        return result;
    }
}
