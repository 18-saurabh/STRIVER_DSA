public class _21JAN_2017_gridGame {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        // Prefix sums for both rows
        long[] row0_sum = new long[n];
        long[] row1_sum = new long[n];
        // Fill prefix sums
        row0_sum[0] = grid[0][0];
        row1_sum[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            row0_sum[i] = row0_sum[i - 1] + grid[0][i];
            row1_sum[i] = row1_sum[i - 1] + grid[1][i];
        }
        // Minimum of the maximum points the second robot can collect
        long result = Long.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            // Points left in row 0 (after column c)
            long pointsAfter = row0_sum[n - 1] - row0_sum[c];

            // Points left in row 1 (before column c)
            long pointsBefore = c > 0 ? row1_sum[c - 1] : 0;

            // Maximum points the second robot can collect
            long maxPoints = Math.max(pointsAfter, pointsBefore);

            // Minimize the result
            result = Math.min(result, maxPoints);
        }
        return result;
    }
}
