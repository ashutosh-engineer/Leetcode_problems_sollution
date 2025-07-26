class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If node already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create new node (clone)
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone); // Mark as visited

        // Recursively clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
