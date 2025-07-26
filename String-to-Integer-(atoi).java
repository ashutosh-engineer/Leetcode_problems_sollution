class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check if string is empty after trimming
        if (i == n) return 0;

        // Step 3: Check sign
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Step 4: Convert number and handle overflow
        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            // Step 5: Clamp to 32-bit signed int range if overflow
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;

            i++;
        }

        return (int) (sign * result);
    }
}
