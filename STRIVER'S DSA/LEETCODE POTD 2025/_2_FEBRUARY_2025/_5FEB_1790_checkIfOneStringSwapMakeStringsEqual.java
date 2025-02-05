public class _5FEB_1790_checkIfOneStringSwapMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int cnt = 0;
        int first = -1;
        int second = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
                if (cnt == 1) {
                    first = i;
                } else if (cnt == 2) {
                    second = i;
                } else
                    return false;
            }
        }
        return cnt == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }
}
