class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = (result << 1) | head.val;  // Left shift and add current bit
            head = head.next;
        }
        return result;
    }
}
