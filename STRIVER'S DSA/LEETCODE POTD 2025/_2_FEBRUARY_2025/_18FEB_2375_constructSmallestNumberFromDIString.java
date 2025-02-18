import java.util.Stack;

public class _18FEB_2375_constructSmallestNumberFromDIString {
    public static String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1); // Push numbers 1 to 9 in order
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                // If 'I' is encountered or end of pattern, pop all from stack
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        return result.toString();
    }
}
