public class _3JAN_2270_numberOfWaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        long leftSum = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;
            if (leftSum >= rightSum) {
                count++;
            }
        }
        return count;
    }
    
    public int rightSum(int[] arr, int j) {
        int n = arr.length;
        int sum = 0;
        for (int i = j; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int brute_waysToSplitArray(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            int rightSum = rightSum(nums, i + 1); // Correctly call the method `rightSum`
            if (leftSum >= rightSum) {
                cnt++;
            }
        }
        return cnt;
    }
}
