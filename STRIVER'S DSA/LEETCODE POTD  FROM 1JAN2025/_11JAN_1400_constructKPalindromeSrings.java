import java.util.HashMap;

public class _11JAN_1400_constructKPalindromeSrings {
    class Solution {
    public boolean canConstruct(String s, int k) {
        // If the length of the string is less than k, return false
        if (s.length() < k) {
            return false;
        }

        // Count the frequency of each character
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Count the number of characters with odd frequency
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // If the number of odd frequencies is greater than k, return false
        return oddCount <= k;
    }
}
}
