import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}
public class _22FEB_1028_recoverAtreeFromPreOrderTraversal {

     public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();
        
        while (i < n) {
            // Step 1: Count the depth (number of dashes)
            int depth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            
            // Step 2: Extract node value
            int value = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            
            TreeNode node = new TreeNode(value);
            
            // Step 3: Adjust stack to maintain correct parent-child relationship
            while (stack.size() > depth) {
                stack.pop();
            }
            
            // Step 4: Attach node to the tree
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            
            // Step 5: Push current node onto the stack
            stack.push(node);
        }
        
        // Root is at the bottom of the stack
        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.peek();
    }
}