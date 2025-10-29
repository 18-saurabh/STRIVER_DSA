import java.util.HashSet;
import java.util.Set;

public class _6_numberOfSubstringContainingAllTheCharacters {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0;
        int count = 0;
        int freq[] = new int[3];
        for (int r = 0; r < n; r++) {
            freq[s.charAt(r) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += n - r;
                freq[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return count;
    }

    public int bruteForce(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> se = new HashSet<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (ch == 'a' || ch == 'b' || ch == 'c') {
                    se.add(ch);
                }
                if (se.size() == 3) {
                    count += n - j;
                    break;
                }
            }
        }
        return count;
    }
}
