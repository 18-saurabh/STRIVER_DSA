import java.util.HashMap;

public class _20JAN_2661_firstCompletelyPaintedRowAndColumn {
      public int firstCompleteIndex(int[] arr, int[][] mat) {
       int m = mat.length;
        int n = mat[0].length;
        // Map each value in mat to its position (row, col)
        HashMap<Integer, int[]> valueToPosition = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valueToPosition.put(mat[i][j], new int[]{i, j});
            }
        }
        // Arrays to track painted rows and columns
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        // Iterate over arr to paint cells
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int[] position = valueToPosition.get(val);
            int row = position[0];
            int col = position[1];
            // Paint the row and column
            rowCount[row]++;
            colCount[col]++;
            // Check if row or column is completely painted
            if (rowCount[row] == n || colCount[col] == m) {
                return i; // Return the index at which a row/column is completely painted
            }
        }

        // Should not reach here if constraints are valid
        return -1;
    }
}
