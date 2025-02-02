import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _22JAN_1765_mapOFhighestPeak {
    public int[][] highestPeak(int[][] isWater) {
       int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int[] row : height) {
            Arrays.fill(row, -1); // Initialize all cells as unvisited
        }

        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the queue with all water cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0; // Water cells have height 0
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Directions for moving north, east, south, and west
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currentHeight = height[cell[0]][cell[1]];

            // Explore all 4 directions
            for (int[] dir : directions) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];

                // Check if the new cell is within bounds and unvisited
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && height[newRow][newCol] == -1) {
                    height[newRow][newCol] = currentHeight + 1; // Increment height
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return height;  
    }
}
