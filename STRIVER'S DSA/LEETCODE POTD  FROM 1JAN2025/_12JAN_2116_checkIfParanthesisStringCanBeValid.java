public class _12JAN_2116_checkIfParanthesisStringCanBeValid {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0)
            return false; // Odd length cannot be valid

        int unlocked = 0, balance = 0;

        // Left-to-right pass: Check for too many ')'
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance + unlocked < 0)
                return false; // Too many ')'
        }

        unlocked = 0;
        balance = 0;

        // Right-to-left pass: Check for too many '('
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == ')') {
                balance++;
            } else {
                balance--;
            }

            if (balance + unlocked < 0)
                return false; // Too many '('
        }

        return true;
    }
}
