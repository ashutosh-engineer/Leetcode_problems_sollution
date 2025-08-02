import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = basket1.length;

        for (int i = 0; i < n; i++) {
            freq.put(basket1[i], freq.getOrDefault(basket1[i], 0) + 1);
            freq.put(basket2[i], freq.getOrDefault(basket2[i], 0) - 1);
        }

        List<Integer> swaps = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int count = e.getValue();
            if (count % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                swaps.add(e.getKey());
            }
        }

        Collections.sort(swaps);
        int min = Math.min(Arrays.stream(basket1).min().getAsInt(), Arrays.stream(basket2).min().getAsInt());
        long cost = 0;

        for (int i = 0; i < swaps.size() / 2; i++) {
            cost += Math.min(swaps.get(i), 2 * min);
        }

        return cost;
    }
}
