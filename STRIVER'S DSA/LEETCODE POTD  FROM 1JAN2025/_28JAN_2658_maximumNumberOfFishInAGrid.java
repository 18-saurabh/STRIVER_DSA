public class _28JAN_2658_maximumNumberOfFishInAGrid {

    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;

        // Iterate through the grid to start at each water cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    maxFish = Math.max(maxFish, dfs(grid, visited, i, j));
                }
            }
        }
        return maxFish;
    }

    private static int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        // Base case: Check boundaries and whether the cell is already visited or land
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        // Mark the cell as visited
        visited[r][c] = true;

        // Fish count in the current cell
        int fishCount = grid[r][c];

        // Explore all 4 possible directions
        fishCount += dfs(grid, visited, r + 1, c); // Down
        fishCount += dfs(grid, visited, r - 1, c); // Up
        fishCount += dfs(grid, visited, r, c + 1); // Right
        fishCount += dfs(grid, visited, r, c - 1); // Left

        return fishCount;
    }
}