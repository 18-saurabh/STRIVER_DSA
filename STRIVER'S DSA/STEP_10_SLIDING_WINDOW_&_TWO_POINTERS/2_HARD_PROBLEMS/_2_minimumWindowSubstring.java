public class _2_minimumWindowSubstring {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }

        int[] hash = new int[256];
        for (int i = 0; i < n; i++) {
            hash[t.charAt(i)]++;
        }

        int minLen = Integer.MAX_VALUE;
        int cnt = 0;
        int sIndex = -1;
        int l = 0, r = 0;

        while (r < m) {
            if (hash[s.charAt(r)] > 0)
                cnt++;

            hash[s.charAt(r)]--;
            r++;

            // When all characters of t are found
            while (cnt == n) {
                if (r - l < minLen) {
                    minLen = r - l;
                    sIndex = l;
                }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0)
                    cnt--;
                l++;
            }
        }

        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
