import java.util.*;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();  // ingredient → list of recipes depending on it
        Map<String, Integer> indegree = new HashMap<>();     // recipe → number of ingredients required

        // Build the graph
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ingList = ingredients.get(i);
            indegree.put(recipe, ingList.size());

            for (String ing : ingList) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Start BFS with all supplies
        Queue<String> queue = new LinkedList<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        for (String supply : supplies) {
            queue.offer(supply);
        }

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String item = queue.poll();

            if (!graph.containsKey(item)) continue;

            for (String recipe : graph.get(item)) {
                indegree.put(recipe, indegree.get(recipe) - 1);

                // All ingredients ready
                if (indegree.get(recipe) == 0) {
                    result.add(recipe);
                    queue.offer(recipe);
                    available.add(recipe);
                }
            }
        }

        return result;
    }
}
