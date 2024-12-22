import java.util.Arrays;

public class _8_aggresiveCows {
     public static boolean canWePlace(int[] stalls, int k, int dist) {
        int cntCows = 1; // Place the first cow
        int last = stalls[0]; // Position of the last placed cow

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows >= k) {
                return true; // All cows placed successfully
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int minDist = 1; // Minimum possible distance
        int maxDist = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        // Perform linear search over possible distances
        for (int dist = minDist; dist <= maxDist; dist++) {
            if (canWePlace(stalls, k, dist)) {
                result = dist; // Update result with the current valid distance
            } else {
                break; // No need to check further as larger distances won't work
            }
        }
        return result;
    }
    
    public static int optimal_aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, k, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
