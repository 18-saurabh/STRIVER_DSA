public class _1_findASquareRootOfNumberInLogN {
    int floorSqrt(int n) {
        // Your code here
        int x = (int) Math.sqrt(n);
        return x;

    }
    
    int optimal_floorSqrt(int n) {
        // Your code here
        int ans = 0;
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = mid * mid;
            if (val == n)
                return mid;
            if (val <= n) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;

    }
}
