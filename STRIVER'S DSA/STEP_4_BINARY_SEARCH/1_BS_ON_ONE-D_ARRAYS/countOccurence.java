public class countOccurence {
    int LOWER_BOUND(int[] nums, int target) {
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

    int UPPER_BOUND(int[] nums, int target) {
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

    int countFreq(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        int lb = LOWER_BOUND(arr, target);
        int ub = UPPER_BOUND(arr, target);
        if (lb == n || arr[lb] != target)
            return count = 0;
        else
            count = (((ub - 1) - lb) + 1);
        return count;
    }
}
