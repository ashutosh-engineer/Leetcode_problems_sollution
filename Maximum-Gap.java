class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Step 1: Find global min and max
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0; // All elements are the same

        // Step 2: Bucket size and count
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] used = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Step 3: Fill buckets
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
            used[idx] = true;
        }

        // Step 4: Compute maximum gap between buckets
        int maxGap = 0;
        int prevMax = min;
        for (int i = 0; i < bucketCount; i++) {
            if (!used[i]) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }
}
