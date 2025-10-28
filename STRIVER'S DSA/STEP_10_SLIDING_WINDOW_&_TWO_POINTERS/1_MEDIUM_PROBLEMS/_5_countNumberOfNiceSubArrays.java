public class _5_countNumberOfNiceSubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }

    public int count(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int arr_count = 0;
        int n = nums.length;
        while (r < n) {
            if (nums[r] % 2 != 0) {
                k--;
            }
            while (k < 0) {
                if (nums[l] % 2 != 0) {
                    k++;
                }
                l++;
            }
            arr_count += r - l + 1;
            r++;
        }
        return arr_count;
    }
}
