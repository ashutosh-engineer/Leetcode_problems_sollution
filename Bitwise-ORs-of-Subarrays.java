import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);

            for (int val : prev) {
                curr.add(val | num);
            }

            result.addAll(curr);
            prev = curr; // carry forward for next iteration
        }

        return result.size();
    }
}
