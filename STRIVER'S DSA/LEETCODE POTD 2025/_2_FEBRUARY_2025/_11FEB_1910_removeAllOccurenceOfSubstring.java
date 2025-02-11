public class _11FEB_1910_removeAllOccurenceOfSubstring {

    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)) { // Keep removing while part exists in s
            s = s.replaceFirst(part, ""); // Remove first occurrence of part
        }
        return s;
    }
}