public class _16FEB_1718_constructTheLexographicallyLargestValidSequence {
    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        int[] result = new int[len];
        boolean[] used = new boolean[n + 1]; // To track used numbers
        backtrack(result, used, 0, n);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        // Base case: if we fill all places, return true
        if (index == result.length)
            return true;

        // If the position is already filled, move to next index
        if (result[index] != 0)
            return backtrack(result, used, index + 1, n);

        // Try placing numbers from `n` down to `1`
        for (int i = n; i >= 1; i--) {
            // If number is already used, skip
            if (used[i])
                continue;

            // Place '1' only once, others need two positions
            int nextIndex = (i == 1) ? index : index + i;
            if (nextIndex < result.length && result[nextIndex] == 0) {
                // Place the number
                result[index] = i;
                if (i != 1)
                    result[nextIndex] = i;
                used[i] = true;

                // Recur
                if (backtrack(result, used, index + 1, n))
                    return true;

                // Backtrack
                result[index] = 0;
                if (i != 1)
                    result[nextIndex] = 0;
                used[i] = false;
            }
        }

        return false;
    }
}
