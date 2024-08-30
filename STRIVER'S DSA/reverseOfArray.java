import java.util.*;

public class reverseOfArray {
    public static void swap(int arr[], int l, int r) {
        int temp;
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static int reverse_Of_Array_1_pointers(int arr[],int i,int n){
        if(i>=n/2) return 0;
        int temp;
        temp=arr [i];
        arr [i]=arr[n-i-1];
        arr[n-i-1]=temp;
        return reverse_Of_Array_1_pointers(arr, i+1,n);
    }

    public static int reverse_Of_Array_2_pointers(int arr[], int l, int r) {  //using two pointers
        if (l >= r)
            return 0;
        swap(arr, l, r);
        return reverse_Of_Array_2_pointers(arr, l + 1, r - 1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements in your array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The elements in array are:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        reverse_Of_Array_2_pointers(arr, 0, n - 1); // using two pointers
        System.out.println("The elements in reversed array are:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
