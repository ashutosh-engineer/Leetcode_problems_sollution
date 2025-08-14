import java.util.*;

class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Characters that can appear in the sequence
        List<Character> chars = new ArrayList<>();
        for (int i = 25; i >= 0; i--) { // reverse for lexicographic largest
            if (freq[i] >= k) {
                chars.add((char) ('a' + i));
            }
        }
        
        String best = "";
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (char c : chars) {
                String next = cur + c;
                if (isKSubsequence(s, next, k)) {
                    if (next.length() > best.length() ||
                       (next.length() == best.length() && next.compareTo(best) > 0)) {
                        best = next;
                    }
                    queue.add(next); // try to expand further
                }
            }
        }
        
        return best;
    }
    
    private boolean isKSubsequence(String s, String seq, int k) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < k; i++) repeated.append(seq);
        return isSubsequence(s, repeated.toString());
    }
    
    private boolean isSubsequence(String s, String pattern) {
        int i = 0, j = 0;
        while (i < s.length() && j < pattern.length()) {
            if (s.charAt(i) == pattern.charAt(j)) j++;
            i++;
        }
        return j == pattern.length();
    }
}
