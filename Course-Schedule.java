import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build graph and indegree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 2: Add all courses with 0 indegree to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int completedCourses = 0;

        // Step 3: Process courses
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            for (int neighbor : graph.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return completedCourses == numCourses;
    }
}
