class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        while (word.length() < k) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                // Get next character in alphabet
                char nextChar = (char)(word.charAt(i) + 1);
                word.append(nextChar);
            }
        }

        return word.charAt(k - 1); // k is 1-based
    }
}
