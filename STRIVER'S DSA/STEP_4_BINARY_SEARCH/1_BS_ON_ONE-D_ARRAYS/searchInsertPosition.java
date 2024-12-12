public class searchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int ans = n;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
