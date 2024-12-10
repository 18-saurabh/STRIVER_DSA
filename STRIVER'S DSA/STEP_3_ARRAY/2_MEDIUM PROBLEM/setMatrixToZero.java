public class setMatrixToZero {

    // Brute Force Approach: Yeh approach rows aur columns ko directly mark karke
    // kaam karta hai
    public void Brute_setZeroes(int[][] matrix) {
        int rows = matrix.length; // Rows ki length nikal rahe hain
        int cols = matrix[0].length; // Columns ki length nikal rahe hain

        // Pehli loop: Yeh matrix ke saare elements ko check karta hai aur agar 0 mile
        // toh row aur column mark karta hai
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) { // Agar element 0 hai
                    markRow(i, matrix); // Uski row ko mark karo
                    markCol(j, matrix); // Uski column ko mark karo
                }
            }
        }

        // Dusri loop: Yeh matrix ke -1 mark kiye hue elements ko 0 me convert karta hai
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == -1) { // Agar element -1 hai, toh usse 0 me badal do
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Yeh function row ke har element ko -1 me mark karta hai agar wo already 0
    // nahi hai
    public void markRow(int i, int[][] matrix) {
        int cols = matrix[0].length; // Column ki length le rahe hain
        for (int j = 0; j < cols; j++) {
            if (matrix[i][j] != 0) { // Agar element 0 nahi hai, toh usko -1 mark karo
                matrix[i][j] = -1;
            }
        }
    }

    // Yeh function column ke har element ko -1 me mark karta hai agar wo already 0
    // nahi hai
    public void markCol(int j, int[][] matrix) {
        int rows = matrix.length; // Row ki length le rahe hain
        for (int i = 0; i < rows; i++) {
            if (matrix[i][j] != 0) { // Agar element 0 nahi hai, toh usko -1 mark karo
                matrix[i][j] = -1;
            }
        }
    }

    // Better Approach: Yeh approach pehle matrix ke rows aur columns ko alag arrays
    // me store karke kaam karta hai
    public void Better_setZeroes(int[][] matrix) {
        int m = matrix.length; // Matrix me kitni rows hain, ye le rahe hain
        int n = matrix[0].length; // Matrix me kitne columns hain, ye le rahe hain
        int rows[] = new int[m]; // Rows ko store karne ke liye ek array banaya
        int cols[] = new int[n]; // Columns ko store karne ke liye ek array banaya

        // Pehli loop: Agar matrix ka koi element 0 hai, toh uske corresponding row aur
        // column ko mark karo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) { // Agar matrix ka element 0 hai
                    rows[i] = 1; // Us row ko mark karo
                    cols[j] = 1; // Us column ko mark karo
                }
            }
        }

        // Dusri loop: Matrix ke elements ko check karke, rows ya columns agar mark hain
        // toh unko 0 me badal do
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 1 || cols[j] == 1) { // Agar row ya column mark kiya hai
                    matrix[i][j] = 0; // Us element ko 0 karo
                }
            }
        }
    }
    public void optimal_setZeroes(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        int x=1,y=1;
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0) x=0;  
        }
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0) y=0;  
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
    }
}
