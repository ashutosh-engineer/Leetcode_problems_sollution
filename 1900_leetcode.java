import java.util.*;

class Solution {
    Map<String, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        return dfs(n, 1, n, firstPlayer, secondPlayer, 1);
    }

    private int[] dfs(int n, int left, int right, int a, int b, int round) {
        if (a > b) {
            int temp = a; a = b; b = temp;  // Always make a < b
        }
        String key = n + "," + a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        if (a + b == n + 1) return new int[]{round, round};  // They are paired this round

        List<int[]> next = new ArrayList<>();
        for (int mask = 0; mask < (1 << (n / 2)); mask++) {
            List<Integer> newList = new ArrayList<>();
            boolean valid = true;
            int l = 1, r = n;
            for (int i = 0; i < n / 2; i++) {
                int x = l++, y = r--;
                boolean pickX = ((mask >> i) & 1) == 0;

                if ((x == a && y == b) || (x == b && y == a)) {
                    valid = false; break;
                }

                if (x == a || x == b || y == a || y == b) {
                    newList.add((x == a || x == b) ? x : y);
                } else {
                    newList.add(pickX ? x : y);
                }
            }

            if (n % 2 == 1) {
                newList.add(l);  // Middle player auto advances
            }

            if (!valid) continue;

            Collections.sort(newList);
            int na = -1, nb = -1;
            for (int i = 0; i < newList.size(); i++) {
                if (newList.get(i) == a) na = i + 1;
                if (newList.get(i) == b) nb = i + 1;
            }

            int[] res = dfs(newList.size(), 1, newList.size(), na, nb, round + 1);
            next.add(res);
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] p : next) {
            min = Math.min(min, p[0]);
            max = Math.max(max, p[1]);
        }

        memo.put(key, new int[]{min, max});
        return memo.get(key);
    }
}
