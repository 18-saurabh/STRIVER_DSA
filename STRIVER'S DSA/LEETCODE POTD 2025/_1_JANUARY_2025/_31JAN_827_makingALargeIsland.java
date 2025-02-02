import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _31JAN_827_makingALargeIsland {
     public int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxArea = 0;
        boolean hasZero = false;
        Map<Integer, Integer> areaMap = new HashMap<>();
        int islandId = 2; // Start from 2 to differentiate from 0 and 1

        // Step 1: Find all islands and store their areas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, islandId);
                    areaMap.put(islandId, area);
                    maxArea = Math.max(maxArea, area);
                    islandId++;
                }
            }
        }

        // Step 2: Check each 0 cell and compute max possible island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    Set<Integer> seenIslands = new HashSet<>();
                    int newArea = 1; // The cell itself

                    for (int[] d : directions) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1) {
                            seenIslands.add(grid[x][y]);
                        }
                    }

                    for (int id : seenIslands) {
                        newArea += areaMap.get(id);
                    }

                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return hasZero ? maxArea : n * n;
    }

    private int dfs(int[][] grid, int i, int j, int islandId) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = islandId; // Mark the cell
        int area = 1;

        for (int[] d : directions) {
            area += dfs(grid, i + d[0], j + d[1], islandId);
        }

        return area;
    }

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

}
