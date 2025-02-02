public class _5JAN_2381_shiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
    int n = s.length();
    int[] diff = new int[n + 1]; // Difference array, size n+1 to handle end index.

    // Populate the difference array based on shifts
    for(
    int[] shift:shifts)
    {
        int start = shift[0], end = shift[1], direction = shift[2];
        int value = direction == 1 ? 1 : -1;
        diff[start] += value;
        if (end + 1 < n) {
            diff[end + 1] -= value;
        }
    }

    // Calculate the prefix sum to determine the net shifts
    int[] netShifts = new int[n];
    int runningSum = 0;for(
    int i = 0;i<n;i++)
    {
        runningSum += diff[i];
        netShifts[i] = runningSum;
    }

    // Apply the shifts to the string
    char[] result = s.toCharArray();for(
    int i = 0;i<n;i++)
    {
        int shift = netShifts[i] % 26; // Ensure shifts are within bounds of alphabet
        if (shift < 0)
            shift += 26; // Handle negative shifts (wrap backward)
        result[i] = (char) ('a' + (result[i] - 'a' + shift) % 26);
    }

    return new String(result);
}
}