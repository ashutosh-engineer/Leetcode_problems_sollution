class Solution {
    public String reverseWords(String s) {
        // 1. Trim leading/trailing spaces
        s = s.trim();

        // 2. Split by one or more spaces using regex
        String[] words = s.split("\\s+");

        // 3. Reverse the words array
        Collections.reverse(Arrays.asList(words));

        // 4. Join with single space
        return String.join(" ", words);
    }
}
