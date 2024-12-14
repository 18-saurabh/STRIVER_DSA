public class firstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = LOWER_BOUND(nums, target);
        if (lb == n || nums[lb] != target)
            return new int[] { -1, -1 };
        int ub = UPPER_BOUND(nums, target);
        return new int[] { lb, ub - 1 };
    }

    public int LOWER_BOUND(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int UPPER_BOUND(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
