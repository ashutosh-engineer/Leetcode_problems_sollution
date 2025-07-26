class Solution {
  public long maxSubarrays(int n, int[][] pairs) {
    long valid = 0;
    int maxLeft = 0, secondMax = 0;
    long[] gains = new long[n + 1];
    List<Integer>[] conflicts = new List[n + 1];
    for (int i = 0; i <= n; ++i) conflicts[i] = new ArrayList<>();

    for (int[] p : pairs) {
      int a = Math.min(p[0], p[1]);
      int b = Math.max(p[0], p[1]);
      conflicts[b].add(a);
    }

    for (int r = 1; r <= n; ++r) {
      for (int l : conflicts[r]) {
        if (l > maxLeft) {
          secondMax = maxLeft;
          maxLeft = l;
        } else if (l > secondMax) {
          secondMax = l;
        }
      }
      valid += r - maxLeft;
      gains[maxLeft] += maxLeft - secondMax;
    }

    long bestGain = 0;
    for (long g : gains) bestGain = Math.max(bestGain, g);
    return valid + bestGain;
  }
}
