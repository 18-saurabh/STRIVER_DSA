import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _1_nextGreaterElement {
    public int[] brute_nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans[] = new int[n];
        for (int i = 0; i < nums1.length; i++) {
            int nums2Index = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    nums2Index = j;
                    break;
                }
            }
            int nextGreater = -1;
            for (int k = nums2Index + 1; k < nums2.length; k++) {
                if (nums2[k] > nums2[nums2Index]) {
                    nextGreater = nums2[k];
                    break;
                }
            }
            ans[i] = nextGreater;
        }
        return ans;
    }

    public int[] stack_nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans[] = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

}
