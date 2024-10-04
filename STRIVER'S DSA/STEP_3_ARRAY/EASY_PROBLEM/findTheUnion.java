
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class findTheUnion {
    public static int[] union(int arr_1[], int arr_2[], int n, int m) {
        Set<Integer> st = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st.add(arr_1[i]);
        }
        for (int i = 0; i < m; i++) {
            st.add(arr_2[i]);
        }

        int union[] = new int[st.size()];
        int i = 0;
        for (int element : st) {
            union[i++] = element;
        }
        return union;
    }

    public static ArrayList<Integer> optimal_union(int arr_1[], int arr_2[], int n, int m) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr_1[i] <= arr_2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr_1[i]){
                    union.add(arr_1[i]);
                }
                i++;

            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != arr_2[j]){
                    union.add(arr_2[j]);
                }
                j++;
            }
        }
        while (i < n) {
            if (union.get(union.size() - 1) != arr_1[i]) {
                union.add(arr_1[i]);
            }
            i++;
        }
        while (j< m) {
            if (union.get(union.size() - 1) != arr_2[j]) {
                union.add(arr_2[j]);
            }
            j++;
        }
        return union;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the first array from the user
        System.out.print("Enter the number of elements in the first array: ");
        int n = scanner.nextInt();
        int[] arr_1 = new int[n];

        // Get the elements of the first array from the user
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n; i++) {
            arr_1[i] = scanner.nextInt();
        }

        // Get the size of the second array from the user
        System.out.print("Enter the number of elements in the second array: ");
        int m = scanner.nextInt();
        int[] arr_2 = new int[m];

        // Get the elements of the second array from the user
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < m; i++) {
            arr_2[i] = scanner.nextInt();
        }

        // // Call the union method and store the result
        // int[] result = union(arr_1, arr_2, n, m);

        // // Display the union of the two arrays
        // System.out.println("The union of the two arrays is:");
        // for (int i : result) {
        // System.out.print(i + " ");
        // }

        ArrayList<Integer> Union = optimal_union(arr_1, arr_2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val : Union)
            System.out.print(val + " ");
        
    scanner.close();
    }
}
