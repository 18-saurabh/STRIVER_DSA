public class _19FEB_1415_theKThLexographicalStringsOfAllHappyStringsOfLengthN {
    private int count = 0;
    private String result = "";

    public String getHappyString(int n, int k) {
        char[] letters = { 'a', 'b', 'c' };
        backtrack(new StringBuilder(), letters, n, k, '\0');
        return result;
    }

    private void backtrack(StringBuilder current, char[] letters, int n, int k, char prev) {
        if (current.length() == n) {
            count++;
            if (count == k) {
                result = current.toString();
            }
            return;
        }

        for (char c : letters) {
            if (c != prev) { // Ensure happy string condition
                current.append(c);
                backtrack(current, letters, n, k, c);
                current.deleteCharAt(current.length() - 1); // Backtrack

                if (!result.isEmpty())
                    return; // Stop early if found
            }
        }
    }
}
