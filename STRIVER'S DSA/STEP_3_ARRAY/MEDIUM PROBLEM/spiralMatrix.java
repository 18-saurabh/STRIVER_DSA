import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    // Yeh function matrix ko spiral order mein traverse karne ke liye hai
    public static List<Integer> spiralOrder(int[][] matrix) {
        // Yeh list final answer store karne ke liye use ho rahi hai
        List<Integer> ans = new ArrayList<>();

        // n matrix ke rows ka size hai aur m columns ka size
        int n = matrix.length;
        int m = matrix[0].length;

        // left, right, top aur bottom boundaries ko define kar rahe hain
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;

        // Jab tak boundaries overlap nahi karti, tab tak loop chalega
        while (left <= right && top <= bottom) {

            // Pehle top row ko left se right tak traverse kar rahe hain
            for (int i = left; i <= right; i++) {
                ans.add(matrix[left][i]); // Leftmost row ke elements ko add karna
            }
            top++; // Top boundary ko move kar diya kyunki top row traverse ho chuki hai

            // Ab right column ko top se bottom tak traverse kar rahe hain
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]); // Rightmost column ke elements ko add karna
            }
            right--; // Right boundary ko move kar diya kyunki right column traverse ho chuka hai

            // Check kar rahe hain agar abhi bhi top boundary bottom se neeche hai
            if (top <= bottom) {
                // Bottom row ko right se left tak traverse karenge
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]); // Bottom row ke elements ko add karna
                }
                bottom--; // Bottom boundary ko move kar diya kyunki bottom row traverse ho chuki hai
            }

            // Check kar rahe hain agar left boundary right se choti ya barabar hai
            if (left <= right) {
                // Ab left column ko bottom se top tak traverse kar rahe hain
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]); // Leftmost column ke elements ko add karna
                }
                left++; // Left boundary ko move kar diya kyunki left column traverse ho chuka hai
            }
        }
        // Spiral order mein matrix ke saare elements return kar rahe hain
        return ans;
    }
}
