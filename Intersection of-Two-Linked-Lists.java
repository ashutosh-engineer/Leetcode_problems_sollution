public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Two pointers starting from each head
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // Traverse both lists, redirect each pointer to the head of the other list after reaching end
        while (ptrA != ptrB) {
            ptrA = (ptrA == null) ? headB : ptrA.next;
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }

        // Either both are null (no intersection) or both point to the intersection node
        return ptrA;
    }
}
