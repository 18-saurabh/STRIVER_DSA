public class binarySearch{
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;// oveflow condition where the low and high
            // could stand on int max so to stop it used this.
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}