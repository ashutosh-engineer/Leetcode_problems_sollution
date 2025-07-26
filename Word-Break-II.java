class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, wordSet, memo);
    }

    private List<String> dfs(String s, int start, Set<String> wordSet,
                             Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        List<String> result = new ArrayList<>();
        int n = s.length();
        if (start == n) {
            result.add("");
        } else {
            for (int end = start + 1; end <= n; end++) {
                String prefix = s.substring(start, end);
                if (!wordSet.contains(prefix)) continue;
                List<String> subs = dfs(s, end, wordSet, memo);
                for (String sub : subs) {
                    String sentence = prefix + (sub.isEmpty() ? "" : " ") + sub;
                    result.add(sentence);
                }
            }
        }
        memo.put(start, result);
        return result;
    }
}
