public class _8JAN_3042_countPrefixSuffixPairsI {
    public boolean prefixSuffix(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 > len2)
            return false;
        String prefix = str2.substring(0, len1);
        String suffix = str2.substring(len2 - len1);
        return str1.equals(prefix) && str1.equals(suffix);
    }

    public int countPrefixSuufixPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prefixSuffix(words[i], words[j]) == true) {
                    count++;
                }
            }
        }
        return count;
    }
}
