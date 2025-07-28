class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int result = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicates = 1; // count of points equal to points[i]
            int max = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicates++; // exact same point
                    continue;
                }

                int gcd = gcd(dy, dx);
                dy /= gcd;
                dx /= gcd;

                // Normalize the direction (to avoid (-1,2) vs (1,-2) being different)
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                String slope = dy + "/" + dx;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                max = Math.max(max, slopeMap.get(slope));
            }

            result = Math.max(result, max + duplicates);
        }

        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
