import java.util.Stack;

public class _8_largestRectangleInHistogram {
    public int brute_largestRectangleArea(int[] heights) {
        //nse calculation
        //pse calculation
        int[] nse = find_nse(heights);
        int[] pse = find_pse(heights);
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nse[i] - pse[i] - 1));
        }
        return maxArea;
    }

    public int[] find_nse(int[] heights) {
            int n = heights.length;
            int[] nse = new int[n];
            Stack<Integer> st = new Stack<>();
        
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                nse[i] = st.isEmpty() ? n : st.peek();
                st.push(i);
            }
        
            return nse;
    }
    
    public int[] find_pse(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 :st.peek();
            st.push(i);
        }

        return pse;
    }
}
