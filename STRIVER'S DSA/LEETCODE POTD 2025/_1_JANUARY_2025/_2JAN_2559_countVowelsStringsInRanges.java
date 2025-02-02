import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _2JAN_2559_countVowelsStringsInRanges {
    static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    // Step 2: Helper function to check if a word starts and ends with a vowel
    static boolean isValid(String word) {
        if (word.length() == 0)
            return false;
        char start = word.charAt(0);
        char end = word.charAt(word.length() - 1);
        return vowels.contains(start) && vowels.contains(end);
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        // Step 3: Build prefix sum array
        int n = words.length;
        int[] prefixSum = new int[n + 1]; // Extra space for easier range sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (isValid(words[i]) ? 1 : 0);
        }

        // Step 4: Answer each query
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            // Count of valid strings in range [li, ri]
            results[i] = prefixSum[ri + 1] - prefixSum[li];
        }

        return results;
    }
}
