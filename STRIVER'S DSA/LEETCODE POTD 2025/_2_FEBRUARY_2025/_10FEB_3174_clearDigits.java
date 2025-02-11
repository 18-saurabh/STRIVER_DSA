import java.util.Stack;

public class _10FEB_3174_clearDigits {
     public String clearDigits(String s) {
       Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Remove the closest non-digit character to its left
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    stack.pop();
                    break;  // Only remove one letter
                }
            } else {
                stack.push(ch);  // Push letters onto stack
            }
        }

        // Convert stack back to string
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        
        return result.toString();  
    }
}
