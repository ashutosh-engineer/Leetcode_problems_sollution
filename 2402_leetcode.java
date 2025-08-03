import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0])); // [endTime, room]

        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        int[] roomUsage = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            long duration = end - start;

            // Free up rooms
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= start) {
                availableRooms.offer((int) occupiedRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                occupiedRooms.offer(new long[]{end, room});
                roomUsage[room]++;
            } else {
                long[] earliest = occupiedRooms.poll();
                long newEnd = earliest[0] + duration;
                occupiedRooms.offer(new long[]{newEnd, earliest[1]});
                roomUsage[(int) earliest[1]]++;
            }
        }

        int maxMeetings = 0, resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (roomUsage[i] > maxMeetings) {
                maxMeetings = roomUsage[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
