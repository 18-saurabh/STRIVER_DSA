
import java.util.*;
public class pascalsTriangle {
    public static int pascalsNumber(int n,int r){  //print the number at given row and column index in pascalsTriangle
        int res=1;
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
    public static void brute_pascalRow(int n){    // print the entire row of pascal triangle
      for (int c=1;c<=n;c++){
      System.out.print(pascalsNumber(n - 1, c - 1)+" ");    
    }
    }
    
    public static void optimal_pascalRow(int n) { // print the entire row of pascal triangle
        int ans=1;
        System.out.print(ans+" ");
        for(int i=1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/i;
            System.out.print(ans+" ");
        }
    }
    public static List<List<Integer>> pascalTriangle(int n) { //Naive approach for print list of elemenet in pascal triangle
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entire Pascal's triangle:
        for (int row = 1; row <= n; row++) {
            List<Integer> tempLst = new ArrayList<>(); // temporary list
            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }
    
    public static int nCr(int n, int r) {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }
    public List<List<Integer>> generate(int numRows) { //Print the entire list in optimal way
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ans.add(generateRows(i));
        }
        return ans;
    }
    public List<Integer> generateRows(int rows) {
        List<Integer> ansRow = new ArrayList<>();
        long ans = 1;
        ansRow.add(1);
        for (int col = 1; col < rows; col++) {
            ans = ans * (rows - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int r=sc.nextInt();
       optimal_pascalRow(r);
    //    brute_pascalRow(r);
    //    int c=sc.nextInt();
    //    System.out.println(pascalsNumber(r-1, c-1));
       sc.close();
    }
}
