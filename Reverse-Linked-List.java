class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // Save next node
            curr.next = prev;              // Reverse pointer
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }

        return prev; // New head
    }
}
