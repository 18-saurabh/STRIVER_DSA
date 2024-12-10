import java.util.ArrayList;
import java.util.Scanner;

public class moveAllZeroToEndOfTheAray {
    public static int[] all_zero_at_the_end(int arr[], int n) {
        ArrayList<Integer> temp = new ArrayList<>(); // T.C=2N //S.C=O(N)
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        int total_zero = temp.size();
        for (int i = 0; i < total_zero; i++) {
            arr[i] = temp.get(i);
        }
        for (int i = total_zero; i < n; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    public static int[] all_zer0_at_end(int arr[], int n) {
        int j = -1; // T.C=O(N) //S.C=O(1)
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1)
            return arr;
        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
        return arr;
    }

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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
        int storage[] = new int[n];
        storage = all_zer0_at_end(arr, n);
        System.out.println("Array After zero at the end");
        for (int i = 0; i < n; i++) {
            System.out.print(storage[i] + " ");
        }
        sc.close();
    }
}
