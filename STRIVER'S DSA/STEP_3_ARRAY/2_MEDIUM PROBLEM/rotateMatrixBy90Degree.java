public class rotateMatrixBy90Degree {

    // Brute-force method to rotate the matrix by 90 degrees
    public void brute_rotate(int[][] matrix) {
        int n = matrix.length; // Matrix ka size (n x n) ko store karte hain
        int ans[][] = new int[n][n]; // Ek naya matrix 'ans' banate hain jo rotated version ko store karega
        for (int i = 0; i < n; i++) { // Matrix ke har row pe iterate karte hain
            for (int j = 0; j < n; j++) { // Har row ka element access karte hain
                ans[j][n - 1 - i] = matrix[i][j]; // Elements ko rotate karke nayi position pe daalte hain
            }
        }
        // Original matrix ko 'ans' ke rotated version se replace karte hain
        for (int i = 0; i < n; i++) { // Fir se har row pe iterate karte hain
            for (int j = 0; j < n; j++) { // Har element ko replace karte hain
                matrix[i][j] = ans[i][j]; // 'matrix' ko 'ans' se update karte hain
            }
        }
    }

    // Optimal method to rotate the matrix by 90 degrees in-place (no extra space)
    public void optimal_rotate(int[][] matrix) {
        int n = matrix.length; // Matrix ka size (n x n) ko store karte hain

        // Step 1: Transpose the matrix (rows ko columns aur columns ko rows mein
        // convert karte hain)
        for (int i = 0; i < n; i++) { // Har row pe iterate karte hain
            for (int j = i; j < n; j++) { // Diagonal ke upar wale elements pe kaam karte hain
                int temp = 0; // Temporary variable to swap values
                temp = matrix[i][j]; // Current element ko temp mein store karte hain
                matrix[i][j] = matrix[j][i]; // Swap matrix[i][j] with matrix[j][i]
                matrix[j][i] = temp; // Diagonal ke upar aur neeche wale elements ko swap karte hain
            }
        }

        // Step 2: Reverse each row to complete the 90-degree rotation
        for (int i = 0; i < n; i++) { // Har row pe iterate karte hain
            for (int j = 0; j < n / 2; j++) { // Har row ko ulta karte hain (left se right swap karte hain)
                int temp = 0; // Temporary variable to swap values
                temp = matrix[i][j]; // Current element ko temp mein store karte hain
                matrix[i][j] = matrix[i][n - 1 - j]; // Left side element ko right side ke element se swap karte hain
                matrix[i][n - 1 - j] = temp; // Right side ke element ko left side pe swap karte hain
            }
        }
    }
}
