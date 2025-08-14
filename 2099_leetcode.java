import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][2]; // [value, index]
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        
        // Step 1: Sort by value (desc)
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        
        // Step 2: Take top k elements
        int[][] topK = Arrays.copyOfRange(arr, 0, k);
        
        // Step 3: Sort by original index (asc)
        Arrays.sort(topK, (a, b) -> a[1] - b[1]);
        
        // Step 4: Extract values
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][0];
        }
        
        return result;
    }
}
