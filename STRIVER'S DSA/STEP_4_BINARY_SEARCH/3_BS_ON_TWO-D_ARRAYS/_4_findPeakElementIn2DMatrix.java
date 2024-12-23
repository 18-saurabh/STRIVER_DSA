public class _4_findPeakElementIn2DMatrix {
    public int maxRowEl(int mat[][], int n, int m, int col) {
        int maxValue = -1;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > maxValue) {
                maxValue = mat[i][col];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;// row
        int m = mat[0].length;// column
        int low = 0;// column1
        int high = m - 1;// last column
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxRowIndex = maxRowEl(mat, n, m, mid);
            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1; // left element
            int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1; // right element
            if (mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right) {
                return new int[] { maxRowIndex, mid };
            } else if (mat[maxRowIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };

    }
}
