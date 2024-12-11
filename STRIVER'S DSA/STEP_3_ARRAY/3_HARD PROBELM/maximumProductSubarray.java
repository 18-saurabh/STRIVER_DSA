public class maximumProductSubarray {
    public int brute_maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product = product * nums[k];
                }
                maxi = Math.max(maxi, product);
            }
        }
        return maxi;
    }

    public int better_maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product = product * nums[j];
            }
            maxi = Math.max(maxi, product);
        }
        return maxi;
    }
    
    public int optimal_maxProduct(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < n; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            maxi = Math.max(maxi, Math.max(prefix, suffix));
        }
        return maxi;
    }
}
