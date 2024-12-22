public class _1_rowsWithMaxOne {
    public int LB(int arr[], int m, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int ind = -1;
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            int cntRow = m - LB(arr[i], m, 1);
            if (cntRow > maxCnt) {
                maxCnt = cntRow;
                ind = i;
            }
        }
        return ind;
    }
}
