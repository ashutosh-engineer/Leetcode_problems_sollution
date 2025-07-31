public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;        // Left shift result to make space
            result |= (n & 1);   // Add the last bit of n
            n >>>= 1;            // Logical shift n to the right
        }
        return result;
    }
}
