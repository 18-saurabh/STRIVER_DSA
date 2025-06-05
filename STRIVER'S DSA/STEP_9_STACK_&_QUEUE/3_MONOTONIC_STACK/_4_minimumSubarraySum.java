import java.util.Stack;

public class _4_minimumSubarraySum {
    public int brute_minEatingSpeedsumSubarrayMins(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % mod;
            }
        }
        return sum;
    }

    public int optimal_sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int) (1e9 + 7);
        int pse[] = new int[n];
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        // nse calculate
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        // pse calculate
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            long count = (long) (left * right);
            sum = (sum + arr[i] * count) % mod;
        }
        return (int) sum;
    }
}
