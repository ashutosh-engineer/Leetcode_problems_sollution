import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, res = 0, n = events.length;

        // Find max day to iterate up to
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        for (int day = 1; day <= maxDay; day++) {
            // Add events starting today
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Attend the event with earliest end day
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }

        return res;
    }
}
