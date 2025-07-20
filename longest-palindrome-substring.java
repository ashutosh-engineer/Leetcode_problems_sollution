
class Solution {
    public String longestPalindrome(String text) {
        if (text == null || text.length() < 1) {
            return "";
        }

        int start = 0;   // Start index of longest palindrome
        int end = 0;     // End index of longest palindrome

        for (int center = 0; center < text.length(); center++) {
            // Expand around a single character (odd-length palindrome)
            int len1 = expandAroundCenter(text, center, center);
            
            // Expand between two characters (even-length palindrome)
            int len2 = expandAroundCenter(text, center, center + 1);

            int maxLength = Math.max(len1, len2);

            if (maxLength > end - start) {
                // Update start and end based on the new max length
                start = center - (maxLength - 1) / 2;
                end = center + maxLength / 2;
            }
        }

        // Return the longest palindrome substring
        return text.substring(start, end + 1);
    }

    // Expand around the given center and return the length of the palindrome
    private int expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        // (right - 1) - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }
}
