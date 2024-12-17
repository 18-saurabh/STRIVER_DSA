import java.util.Arrays;

public class _3_KokoEatingBananas {
    public int brute_minEatingSpeed(int[] piles, int h) {
        int maxElement = Arrays.stream(piles).max().getAsInt();// Finds maximum from the array
        for (int i = 1; i <= maxElement; i++) {
            int reqTime = requireHour(piles, i);
            if (reqTime <= h) {
                return i;
            }
        }
        return 0;
    }

    public int requireHour(int[] arr, int hourly) {
        int n = arr.length;
        int totalHours = 0;
        for (int i = 0; i < n; i++) {
            totalHours += Math.ceil((double) arr[i] / hourly);
        }
        return totalHours;
    }

    public int optimal_minEatingSpeed(int[] piles, int h) {
        int maxElement = Arrays.stream(piles).max().getAsInt();// Finds maximum from the array
        int low=1;
        int high=maxElement;
        while(low<=high){
            int mid=low+(high-low)/2;
            int totalHours = requireHour(piles, mid);
            if(totalHours<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

}
