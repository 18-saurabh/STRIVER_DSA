public class _3_longestRepeatingCharacterReplacement {
      public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int max_length = 0;
        int max_count = 0;
        int freq[] = new int[26];
        while (r < n) {
            freq[s.charAt(r) - 'A']++;
            max_count = Math.max(max_count, freq[s.charAt(r) - 'A']);
            while ((r - l + 1) - max_count > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            max_length = Math.max(max_length, r - l + 1);
            r++;
        }
        return max_length;
    }

    public int bruteForceCharacterReplacement(String s, int k) {
        int n = s.length();
        int max_length = 0;
        for (int i = 0; i < n; i++) {
            int freq[] = new int[26];
            int max_freq = 0;
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'A']++;
                max_freq = Math.max(freq[s.charAt(j) - 'A'], max_freq);
                int changes = (j - i + 1) - max_freq;
                if (changes <= k) {
                    max_length = Math.max(max_length, j - i + 1);
                } else
                    break;
            }
        }
        return max_length;
    }
}
