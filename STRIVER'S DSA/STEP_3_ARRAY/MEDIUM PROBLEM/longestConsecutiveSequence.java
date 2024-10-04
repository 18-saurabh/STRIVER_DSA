import java.util.Arrays;
import java.util.HashSet;

public class longestConsecutiveSequence {
    public static int brute_LongestConsecutiveSequence(int a[]) {
        int n = a.length;
        int longest = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int x = a[i];
            while (linearSearch(x + 1, a) == true) {
                x += 1;
                cnt += 1;
            }
            longest = cnt;
        }
        return longest;
    }

    public static boolean linearSearch(int x, int a[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == (x)) {
                return true;
            }
        }
        return false;
    }

    public static int better_longestConsecutive(int nums[]) {
        Arrays.sort(nums);
        int n = nums.length;
        int longest = 0;
        int lastMin = Integer.MIN_VALUE;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastMin) {
                cnt += 1;
                lastMin = nums[i];
            } else if (nums[i] != lastMin) {
                cnt = 1;
                lastMin = nums[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    public static int optimal_longestConsecutive(int nums[]) {
        int longest = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int it:set) {
            int x = it;
            if (!set.contains(x - 1)) {
                int cnt = 1;
                while (set.contains(x + 1)) {
                    x += 1;
                    cnt += 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

}
