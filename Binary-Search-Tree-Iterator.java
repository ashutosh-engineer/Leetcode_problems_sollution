import java.util.*;

public class BSTIterator {
    private Deque<TreeNode> stack = new ArrayDeque<>();
    
    public BSTIterator(TreeNode root) {
        pushLeftPath(root);
    }
    
    /** @return whether there is a next (smallest) element left */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pollLast();
        // Push left path of right subtree
        if (node.right != null) {
            pushLeftPath(node.right);
        }
        return node.val;
    }
    
    // Helper to push all left children starting from given node
    private void pushLeftPath(TreeNode root) {
        while (root != null) {
            stack.offerLast(root);
            root = root.left;
        }
    }
}

// Definition for the tree node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
    TreeNode(int v, TreeNode l, TreeNode r) { val = v; left = l; right = r; }
}
