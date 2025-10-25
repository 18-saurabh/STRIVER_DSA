public class _2_maximumConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max_len, l, r, zeros;
        max_len = l = r = zeros = 0;
        while (r < n) {
            if (nums[r] == 0)
                zeros++;
            while (zeros > k) {
                if (nums[l] == 0)
                    zeros--;
                l++;
            }
            if (zeros <= k) {
                int len = r - l + 1;
                max_len = Math.max(len, max_len);
            }
            r++;
        }
        return max_len;
    }

    public int brute_force(int[] nums, int k) {
        int n = nums.length;
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) zeros++;
                if (zeros <= k) {
                    int len = j - i + 1;
                    max_len = Math.max(max_len, len);
                } else break;
            }
        }
        return max_len;
    }
}
