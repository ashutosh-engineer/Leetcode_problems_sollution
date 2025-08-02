import java.util.*;

class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = startTime[i];
            meetings[i][1] = endTime[i];
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int maxFree = 0;
        maxFree = Math.max(maxFree, meetings[0][0]);
        for (int i = 1; i < n; i++) {
            maxFree = Math.max(maxFree, meetings[i][0] - meetings[i - 1][1]);
        }
        maxFree = Math.max(maxFree, eventTime - meetings[n - 1][1]);

        // Try moving each meeting somewhere else
        for (int i = 0; i < n; i++) {
            int dur = meetings[i][1] - meetings[i][0];

            // Build list of remaining meetings (excluding i)
            List<int[]> others = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (j != i) others.add(meetings[j]);
            }

            // Sort remaining
            others.sort(Comparator.comparingInt(a -> a[0]));

            // Try placing at beginning
            if (isFreeSlot(others, 0, dur, eventTime)) {
                int free = calcMaxFree(others, 0, dur, eventTime);
                maxFree = Math.max(maxFree, free);
            }

            // Try between meetings
            for (int j = 0; j <= others.size(); j++) {
                int prevEnd = (j == 0) ? 0 : others.get(j - 1)[1];
                int nextStart = (j == others.size()) ? eventTime : others.get(j)[0];

                if (nextStart - prevEnd >= dur) {
                    if (isFreeSlot(others, prevEnd, dur, eventTime)) {
                        int free = calcMaxFree(others, prevEnd, dur, eventTime);
                        maxFree = Math.max(maxFree, free);
                    }
                }
            }
        }

        return maxFree;
    }

    // Check if [start, start+dur] overlaps with any meetings
    private boolean isFreeSlot(List<int[]> meetings, int start, int dur, int eventTime) {
        int end = start + dur;
        if (end > eventTime) return false;

        for (int[] m : meetings) {
            if (Math.max(start, m[0]) < Math.min(end, m[1])) {
                return false; // overlap
            }
        }
        return true;
    }

    // Add [start, start+dur] to meetings and calculate max free time
    private int calcMaxFree(List<int[]> meetings, int start, int dur, int eventTime) {
        List<int[]> all = new ArrayList<>(meetings);
        all.add(new int[]{start, start + dur});
        all.sort(Comparator.comparingInt(a -> a[0]));

        int maxGap = all.get(0)[0];
        for (int i = 1; i < all.size(); i++) {
            maxGap = Math.max(maxGap, all.get(i)[0] - all.get(i - 1)[1]);
        }
        maxGap = Math.max(maxGap, eventTime - all.get(all.size() - 1)[1]);
        return maxGap;
    }
}
