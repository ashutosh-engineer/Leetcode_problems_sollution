public class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) 1e14;  // Upper bound (worst case: rank=1, all cars repaired by one person)
        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canRepairAll(ranks, cars, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canRepairAll(int[] ranks, int cars, long timeLimit) {
        long total = 0;
        for (int rank : ranks) {
            total += (long) Math.sqrt(timeLimit / rank);
            if (total >= cars) return true;
        }
        return false;
    }
}
