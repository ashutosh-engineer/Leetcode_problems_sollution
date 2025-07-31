import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with root

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Capture the rightmost node of the level
                if (i == levelSize - 1) {
                    result.add(current.val);
                }

                // Add left and right children to the queue
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }

        return result;
    }
}
