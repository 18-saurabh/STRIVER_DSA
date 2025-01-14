import java.util.HashSet;

public class _14JAN_2637_findPrefixCommonArrayOfTwoArrays {
     public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[]c=new int[n];
        HashSet<Integer>seen=new HashSet<>();
        int counter=0;
        for(int i=0;i<n;i++){
            if(seen.contains(A[i])){
                counter++;
            }
            else{
                seen.add(A[i]);
            }
            if(seen.contains(B[i])){
                counter++;
            }
            else{
                seen.add(B[i]);
            }
            c[i]=counter;
        }
        return c;
    }
}
