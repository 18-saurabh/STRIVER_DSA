public class _4FEB_1800_maximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int max_sum = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                max_sum = Math.max(max_sum, sum);
                sum = nums[i];
            }
        }
        max_sum = Math.max(max_sum, sum);
        return max_sum;
    }
}
