import java.util.Stack;

public class _2_nextGreaterElement2 {
    public int[] brute_nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        for (int i = 0; i < n; i++) {
            nge[i] = -1;
            for (int j = 1; j < n; j++) {
                int ind = (i + j) % n;
                if (nums[ind] > nums[i]) {
                    nge[i] = nums[ind];
                    break;
                }
            }
        }
        return nge;
    }

    public int[] stack_nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int nge[] = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (i < n) {
                nge[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return nge;
    }

}