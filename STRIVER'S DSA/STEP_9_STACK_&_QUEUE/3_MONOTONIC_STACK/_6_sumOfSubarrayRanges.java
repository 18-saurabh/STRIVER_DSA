import java.util.Stack;

public class _6_sumOfSubarrayRanges {
    public long brute_subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (long) (max - min);
            }
        }
        return sum;
    }

    public Long optimal_subArrayRanges(int[] nums) {
        return subArrayMaximum(nums) - subArrayMinimum(nums);
    }

    public Long subArrayMinimum(int[] nums) {
        Long sum = 0L;
        int n = nums.length;
        int[] pse = new int[n];
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        //nse calculation
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        //pse calculation
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            long count = (long) (left * right);
            sum += (long) (nums[i] * count);
        }
        return sum;
    }
    
    public Long subArrayMaximum(int[] nums) {
        Long sum = 0L;
        int n = nums.length;
        int[] pge = new int[n];
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        // nse calculation
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        // pse calculation
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;
            long count = (long) (left * right);
            sum += (long) (nums[i] * count);
        }
        return sum;
    }

}
