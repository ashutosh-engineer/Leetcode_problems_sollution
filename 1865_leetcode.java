import java.util.*;

class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> count2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        count2 = new HashMap<>();
        for (int v : nums2) {
            count2.merge(v, 1, Integer::sum);
        }
    }

    public void add(int index, int val) {
        int old = nums2[index];
        // Decrement frequency of old value
        count2.put(old, count2.get(old) - 1);
        // Update the value in nums2
        nums2[index] += val;
        // Increment frequency of new value
        count2.merge(nums2[index], 1, Integer::sum);
    }

    public int count(int tot) {
        int ans = 0;
        for (int v : nums1) {
            ans += count2.getOrDefault(tot - v, 0);
        }
        return ans;
    }
}
