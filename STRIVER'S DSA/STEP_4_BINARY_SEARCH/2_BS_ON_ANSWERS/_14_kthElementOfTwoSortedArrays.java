import java.util.ArrayList;

public class _14_kthElementOfTwoSortedArrays {
    public int kthElement(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        ArrayList<Integer> c = new ArrayList<>(n1 + n2);
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] <= b[j]) {
                c.add(a[i]);
                i++;
            } else {
                c.add(b[j]);
                j++;
            }
        }
        while (i < n1) {
            c.add(a[i]);
            i++;
        }
        while (j < n2) {
            c.add(b[j]);
            j++;
        }
        return c.get(k - 1);
    }

    public int better_kthElement(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        int ans=0;
        int el1=-1;
        int el2=-1;
        int ind1=0;
        int ind2=0;
        int i=0,j=0;
        while(i<n1&&j<n2){
            
        }
        return ans;
    }
}