class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] duration = new int[n];
        for (int i = 0; i < n; i++) {
            duration[i] = endTime[i] - startTime[i];
        }

        // Binary search on maximum gap value
        int low = 0, high = eventTime;
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canAchieveGap(mid, k, duration, eventTime)) {
                answer = mid;
                low = mid + 1; // Try to find a bigger gap
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canAchieveGap(int requiredGap, int k, int[] duration, int eventTime) {
        int n = duration.length;
        int rescheduleCount = 0;

        int currentTime = 0;
        int maxGap = 0;

        for (int i = 0; i < n; i++) {
            int originalStart = currentTime;
            int originalEnd = currentTime + duration[i];

            // Check if rescheduling helps
            if (i > 0 && currentTime < endTimeOfPrevious(duration, i)) {
                rescheduleCount++;
                if (rescheduleCount > k) return false;
            }

            maxGap = Math.max(maxGap, originalStart - (i == 0 ? 0 : endTimeOfPrevious(duration, i)));

            currentTime = originalEnd;
        }

        maxGap = Math.max(maxGap, eventTime - currentTime);
        return maxGap >= requiredGap;
    }

    private int endTimeOfPrevious(int[] duration, int index) {
        int time = 0;
        for (int i = 0; i < index; i++) {
            time += duration[i];
        }
        return time;
    }
}
