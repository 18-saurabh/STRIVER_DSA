import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _18JAN_1368_minimumCostToMakeAtLeastOneValidPathInAGrid {

     public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // right, left, down, up
        int[][] cost = new int[m][n];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0, 0}); // {row, col, cost}
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int x = curr[0], y = curr[1], currCost = curr[2];

            // If we reach the target, return the cost
            if (x == m - 1 && y == n - 1) return currCost;

            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0], ny = y + directions[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newCost = currCost + (grid[x][y] == i + 1 ? 0 : 1);
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        if (grid[x][y] == i + 1) {
                            deque.offerFirst(new int[]{nx, ny, newCost}); // Weight = 0
                        } else {
                            deque.offerLast(new int[]{nx, ny, newCost}); // Weight = 1
                        }
                    }
                }
            }
        }

        return -1; // Should not reach here
    }
}