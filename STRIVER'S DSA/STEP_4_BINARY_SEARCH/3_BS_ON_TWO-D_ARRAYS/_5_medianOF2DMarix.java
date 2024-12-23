import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class _5_medianOF2DMarix {
    public static int brute_median(int mat[][]) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans.add(mat[i][j]);
            }
        }
        Collections.sort(ans);
        return ans.get((n*m)/2);
    }
    //OPTIMAL APPROACH

    public int UB(int mat[], int x) {
        int n = mat.length;
        int ans = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mat[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int blackBox(int mat[][], int mid) {
        int n = mat.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += UB(mat[i], mid);
        }
        return cnt;
    }

    int median(int mat[][]) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }
        int req = (n * m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallCount = blackBox(mat, mid);
            if (smallCount <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
