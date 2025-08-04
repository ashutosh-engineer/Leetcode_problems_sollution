import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int k, int n, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (path.size() > k || n < 0) return;

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtrack(i + 1, k, n - i, path, res);
            path.remove(path.size() - 1);
        }
    }
}
