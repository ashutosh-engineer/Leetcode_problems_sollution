import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        
        if (!dict.contains(endWord)) return result;

        // Step 1: BFS to build the graph and track levels
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, dict, graph, distance);

        // Step 2: DFS to build all paths using graph
        List<String> path = new ArrayList<>();
        dfs(endWord, beginWord, graph, distance, path, result);
        
        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> dict,
                     Map<String, List<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        for (String word : dict) graph.put(word, new ArrayList<>());
        graph.put(beginWord, new ArrayList<>());

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int currDist = distance.get(curr);

                for (String neighbor : getNeighbors(curr, dict)) {
                    graph.get(neighbor).add(curr); // reverse edge for backward DFS

                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currDist + 1);
                        if (neighbor.equals(endWord)) foundEnd = true;
                        else queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd) break; // only shortest paths
        }
    }

    private void dfs(String curr, String beginWord, Map<String, List<String>> graph,
                     Map<String, Integer> distance, List<String> path, List<List<String>> result) {
        path.add(curr);

        if (curr.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
        } else {
            for (String prev : graph.get(curr)) {
                if (distance.get(prev) + 1 == distance.get(curr)) {
                    dfs(prev, beginWord, graph, distance, path, result);
                }
            }
        }

        path.remove(path.size() - 1);
    }

    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char orig = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == orig) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (dict.contains(newWord)) neighbors.add(newWord);
            }
            chars[i] = orig;
        }

        return neighbors;
    }
}
