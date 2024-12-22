public class _2_searchIn2DMatrixI {
    public boolean searchTarget(int arr[], int m, int target) {
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public boolean brute_searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (searchTarget(matrix[i], m, target)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean optimalsearchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low = 0;
        int high = n*m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid/m][mid%m] == target) {
                return true;
            }
            if (matrix[low/m][low%m] <= matrix[mid/m][mid%m]) {
                if (target >= matrix[low/m][low%m] && target <= matrix[mid/m][mid%m]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= matrix[mid/m][mid%m] && target <= matrix[high/m][high%m]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
