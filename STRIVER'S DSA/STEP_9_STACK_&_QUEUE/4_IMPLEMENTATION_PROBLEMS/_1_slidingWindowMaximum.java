import java.util.ArrayList;
import java.util.List;

public class _1_slidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            maxList.add(max);
        }
        return maxList.stream().mapToInt(i -> i).toArray();
    }
    // Optimized approach using deque
    // public int[] maxSlidingWindow(int[] nums, int k) {
    public static void main(String[] args) {
        _1_slidingWindowMaximum solution = new _1_slidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
