import java.util.ArrayList;
import java.util.List;

public class _10JAN_916_wordsSubset {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();

        // Step 1: Calculate the maximum frequency for each character in words2
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] freq = getCharFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        // Step 2: Check each word in words1 against the maxFreq
        for (String word : words1) {
            int[] freq = getCharFrequency(word);
            boolean isUniversal = true;

            // Ensure word meets all maxFreq requirements
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                ans.add(word);
            }
        }

        return ans;
    }

    // Helper function to count character frequencies in a word
    private int[] getCharFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
