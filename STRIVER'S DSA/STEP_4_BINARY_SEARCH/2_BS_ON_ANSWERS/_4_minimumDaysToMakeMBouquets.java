import java.util.Arrays;

public class _4_minimumDaysToMakeMBouquets {
    public boolean possible(int[] bloomDay, int day, int m, int k) {
        int cnt = 0;
        int noOfBouquets = 0;
        int n = bloomDay.length;

        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= day) {
                cnt++; // Increment count if the flower blooms on or before 'day'
            } else {
                noOfBouquets += cnt / k; // Add complete bouquets possible
                cnt = 0; // Reset count
            }
        }
        noOfBouquets += cnt / k; // Add bouquets for the last segment

        return noOfBouquets >= m; // Return true if enough bouquets are possible
    }

    public int brute_minDays(int[] bloomDay, int m, int k) {
        int min = Arrays.stream(bloomDay).min().getAsInt();
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int n = bloomDay.length;
        if (m * k > n)
            return -1;
        for (int i = min; i <= max; i++) {
            if (possible(bloomDay, i, m, k) == true) {
                return i;
            }
        }
        return -1;
    }
    
    public int optimal_minDays(int[] bloomDay, int m, int k) {
        int min = Arrays.stream(bloomDay).min().getAsInt();
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int n = bloomDay.length;
        int low=min;
        int high=max;
        if (m * k > n)
            return -1;
        while (low<=high) {
            int mid=(low+high)/2;
            if (possible(bloomDay, mid, m, k)) {
                return mid;
            }
        }
        return -1;
    }
}
