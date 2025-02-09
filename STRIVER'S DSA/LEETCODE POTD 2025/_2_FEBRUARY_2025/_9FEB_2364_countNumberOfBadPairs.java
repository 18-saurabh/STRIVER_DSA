import java.util.HashMap;

public class _9FEB_2364_countNumberOfBadPairs {
    public long countBadPairs(int[] nums) {
        // int n = nums.length;
        // long cnt = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         if (nums[j] - nums[i] != j - i) {
        //             cnt++;
        //         }
        //     }
        // }
        
        // return cnt;
         int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2; // Total pairs (i, j) where i < j
        long goodPairs = 0;
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int j = 0; j < n; j++) {
            int key = nums[j] - j; // Transforming equation: nums[j] - j
            goodPairs += freq.getOrDefault(key, 0); // Count how many times this key appeared before
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        
        return totalPairs - goodPairs; // Bad pairs = Total pairs - Good pairs
    }
}
