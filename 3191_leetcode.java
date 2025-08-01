import java.util.*;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();   // ingredient -> recipes that depend on it
        Map<String, Integer> indegree = new HashMap<>();      // recipe -> # of missing ingredients

        // Build the dependency graph
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ingList = ingredients.get(i);
            indegree.put(recipe, ingList.size());

            for (String ing : ingList) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Initialize the queue with supplies
        Queue<String> queue = new LinkedList<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        queue.addAll(available);

        List<String> result = new ArrayList<>();

        // BFS
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (!graph.containsKey(current)) continue;

            for (String dependentRecipe : graph.get(current)) {
                indegree.put(dependentRecipe, indegree.get(dependentRecipe) - 1);
                if (indegree.get(dependentRecipe) == 0) {
                    result.add(dependentRecipe);
                    queue.offer(dependentRecipe);
                    available.add(dependentRecipe);
                }
            }
        }

        return result;
    }
}
