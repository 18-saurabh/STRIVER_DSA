public class _2_findNthRootOfANumber {
    public int nthRoot(int n, int m) {
        // code here
        for (int i = 1; i < m; i++) {
            if (Math.pow(i, n) == m) {
                return i;
            } else if (Math.pow(i, n) > m) {
                break;
            }
        }
        return -1;
    }
    
    public int optimal_nthRoot(int n, int m) {
        // code here
        int low=1;
        int high=m;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if (Math.pow(mid,n)<=m) {
                return mid;
            }
            else{
                high=mid-1;
            }
            
        }
        return -1;
    }
}
