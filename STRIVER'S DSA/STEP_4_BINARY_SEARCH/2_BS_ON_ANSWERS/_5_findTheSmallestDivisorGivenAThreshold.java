import java.util.Arrays;

public class _5_findTheSmallestDivisorGivenAThreshold {
    public boolean divisor(int nums[], int divisor, int threshold) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (int) Math.ceil((double) nums[i] / divisor);
        }
        if (sum <= threshold) {
            return true;
        }
        return false;
    }

    public int brutesmallestDivisor(int[] nums, int threshold) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        for (int i = 1; i <= maxElement; i++) {
            if (divisor(nums, i, threshold) == true) {
                return i;
            }
        }
        return -1;
    }
    
    public int optimal_smallestDivisor(int[] nums, int threshold) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int low=1;
        int high=maxElement;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if (divisor(nums, mid, threshold)==true) {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
