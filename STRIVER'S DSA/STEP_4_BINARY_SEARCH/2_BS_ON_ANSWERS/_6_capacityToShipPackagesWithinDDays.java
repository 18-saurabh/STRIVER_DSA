import java.util.Arrays;

public class _6_capacityToShipPackagesWithinDDays {
    public int days(int weights[], int capacity) {
        int days = 1; // Start with 1 day
        int load = 0; // Current load for the day

        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacity) {
                days++; // New day required
                load = weights[i]; // Start new day with current weight
            } else {
                load += weights[i]; // Add weight to current day's load
            }
        }
        return days;
    }

    public int arraySum(int weights[]) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        return sum;
    }

    public int brute_shipWithinDays(int[] weights, int days) {
        int max = Arrays.stream(weights).max().getAsInt(); // Minimum possible capacity
        int sum = arraySum(weights); // Maximum possible capacity

        // Linear search for minimum capacity
        for (int capacity = max; capacity <= sum; capacity++) {
            if (days(weights, capacity) <= days) {
                return capacity; // Found the smallest capacity
            }
        }

        return -1; // Default return value (this line will never be reached)
    }
    
    public int optimal_shipWithinDays(int[] weights, int days) {
        int max = Arrays.stream(weights).max().getAsInt(); // Minimum possible capacity
        int sum = arraySum(weights); // Maximum possible capacity
        int low=max;
        int high=sum;
        while (low<=high) {
            int mid=(low+high)/2;
            if (days(weights, mid)<=days) {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
