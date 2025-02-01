import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _30JAN_2493_divideNodesIntoMaximumNumberOfGroups {
public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the adjacency list
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 1: Check if the graph is bipartite
        int[] color = new int[n + 1]; // 0 = uncolored, 1 = color1, -1 = color2
        Arrays.fill(color, 0);
        
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!isBipartite(graph, color, i)) return -1;
            }
        }
        
        // Step 2: Compute max depth for each component
        boolean[] visited = new boolean[n + 1];
        int maxGroups = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                collectComponent(graph, visited, i, component);
                
                // Find max depth in this component
                int maxDepth = 0;
                for (int node : component) {
                    maxDepth = Math.max(maxDepth, bfsDepth(graph, node));
                }
                
                maxGroups += maxDepth;
            }
        }

        return maxGroups;
    }
    
    // BFS function to check if the graph is bipartite
    private boolean isBipartite(List<List<Integer>> graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == 0) { // Not colored yet
                    color[neighbor] = -color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // Odd-length cycle found
                }
            }
        }
        
        return true;
    }

    // BFS function to compute max depth in the component
    private int bfsDepth(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();
        queue.add(start);
        depth.put(start, 1);
        
        int maxDepth = 1;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentDepth = depth.get(node);
            
            for (int neighbor : graph.get(node)) {
                if (!depth.containsKey(neighbor)) {
                    depth.put(neighbor, currentDepth + 1);
                    maxDepth = Math.max(maxDepth, currentDepth + 1);
                    queue.add(neighbor);
                }
            }
        }
        
        return maxDepth;
    }

    // Collect all nodes in a connected component using BFS
    private void collectComponent(List<List<Integer>> graph, boolean[] visited, int start, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            component.add(node);
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}