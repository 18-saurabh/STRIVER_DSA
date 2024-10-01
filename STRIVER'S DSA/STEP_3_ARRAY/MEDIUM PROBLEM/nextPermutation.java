public class nextPermutation {
    public void only_nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;

        // Step 1: Find the first decreasing element from the end
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) { // Fix the condition to find the correct index
                ind = i;
                break;
            }
        }

        // Step 2: If no such element is found, reverse the whole array (smallest
        // permutation)
        if (ind == -1) {
            reverse(0, n - 1, nums);
            return;
        }

        // Step 3: Find the next larger element to swap with nums[ind]
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(ind, i, nums); // Swap the two elements
                break;
            }
        }

        // Step 4: Reverse the elements after the swapped index to get the next
        // permutation
        reverse(ind + 1, n - 1, nums);
    }

    // Reverse function to reverse the array between indices 'start' and 'end'
    public void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Swap function to swap elements at index 'a' and 'b'
    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
