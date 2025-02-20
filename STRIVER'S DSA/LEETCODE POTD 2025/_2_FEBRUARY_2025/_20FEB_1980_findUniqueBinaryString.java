import java.util.HashSet;
import java.util.Set;

public class _20FEB_1980_findUniqueBinaryString {
      public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        
        // Add all given binary strings into a HashSet
        for (String num : nums) {
            set.add(num);
        }
        
        // Try generating a unique binary string using diagonalization
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // Flip the i-th bit of the i-th string to ensure uniqueness
            char bit = nums[i].charAt(i) == '0' ? '1' : '0';
            sb.append(bit);
        }
        
        // Ensure it's unique
        String candidate = sb.toString();
        return set.contains(candidate) ? generateAnyUnique(n, set) : candidate;
    }

    // Backup function to generate any unique binary string
    private static String generateAnyUnique(int n, Set<String> set) {
        for (int i = 0; i < (1 << n); i++) {
            String binary = Integer.toBinaryString(i);
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            if (!set.contains(binary)) {
                return binary;
            }
        }
        return "";
}
}
