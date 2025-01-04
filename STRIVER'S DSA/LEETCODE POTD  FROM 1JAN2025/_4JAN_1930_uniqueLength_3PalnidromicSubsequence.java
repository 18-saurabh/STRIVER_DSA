import java.util.HashSet;

public class _4JAN_1930_uniqueLength_3PalnidromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashSet<String> uniquePalindromes = new HashSet<>();
        // Arrays to store the first and last occurrence of each character
        int[] firstOccurrence = new int[26];
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < 26; i++) {
            firstOccurrence[i] = -1;
            lastOccurrence[i] = -1;
        }
        // Populate first and last occurrence arrays
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (firstOccurrence[idx] == -1) {
                firstOccurrence[idx] = i;
            }
            lastOccurrence[idx] = i;
        }
        // Iterate over each character and check for valid palindromes
        for (int i = 0; i < 26; i++) {
            if (firstOccurrence[i] != -1 && lastOccurrence[i] != -1 && firstOccurrence[i] < lastOccurrence[i]) {
                HashSet<Character> middleChars = new HashSet<>();
                for (int j = firstOccurrence[i] + 1; j < lastOccurrence[i]; j++) {
                    middleChars.add(s.charAt(j));
                }
                for (char c : middleChars) {
                    String palindrome = "" + (char) (i + 'a') + c + (char) (i + 'a');
                    uniquePalindromes.add(palindrome);
                }
            }
        }
        return uniquePalindromes.size();
    }
}