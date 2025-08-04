class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        // Break building into two events: start and end
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]}); // Start of building, negative height
            heights.add(new int[]{b[1], b[2]});  // End of building, positive height
        }

        // Sort by x-coordinate, and height
        heights.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]); // for same x, start before end
        });

        // Max-heap to keep track of current building heights
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0); // Ground level

        List<List<Integer>> result = new ArrayList<>();
        int prevMax = 0;

        for (int[] h : heights) {
            int x = h[0], height = h[1];
            if (height < 0) {
                pq.add(-height); // start event, add height
            } else {
                pq.remove(height); // end event, remove height
            }

            int currentMax = pq.peek();
            if (currentMax != prevMax) {
                result.add(Arrays.asList(x, currentMax));
                prevMax = currentMax;
            }
        }

        return result;
    }
}
