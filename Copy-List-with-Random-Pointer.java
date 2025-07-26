class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Map from original node -> copied node
        Map<Node, Node> map = new HashMap<>();

        // First pass: create new nodes
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: assign next and random
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
