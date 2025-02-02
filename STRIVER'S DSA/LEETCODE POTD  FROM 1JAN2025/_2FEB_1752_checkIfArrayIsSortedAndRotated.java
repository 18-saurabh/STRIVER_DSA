public class _2FEB_1752_checkIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int countBreaks = 0;
        int n = nums.length;
        
        // Check for breaks in the array
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                countBreaks++;
            }
            // If there is more than one break, return false
            if (countBreaks > 1) {
                return false;
            }
        }
        return true;

    }
}
