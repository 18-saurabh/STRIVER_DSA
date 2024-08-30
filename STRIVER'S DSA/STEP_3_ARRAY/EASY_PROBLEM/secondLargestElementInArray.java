import java.util.*;

public class secondLargestElementInArray {
    public static int second_Largest_Element_In_Array(int arr[]) {
        // int largest_element=arr[0];                                //T.C=O(2N)
        // int s_largest_element=-1;
        // for (int i = 1; i < arr.length; i++) {
        // if (arr[i] > largest_element) {
        // largest_element = arr[i];
        // }
        // }
        // for (int i = 0; i < arr.length; i++) {
        // if (arr[i]<largest_element && arr[i]>s_largest_element) {
        // s_largest_element= arr[i];
        // }
        // }
        // return s_largest_element;

        int largest_element = arr[0];                            // T.C=O(N)
        int s_largest_element = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest_element) {
                s_largest_element = largest_element;
                largest_element = arr[i];
            }
            else if (arr[i] < largest_element && arr[i]>s_largest_element) {
                s_largest_element = arr[i];
            }
        }
        return s_largest_element;
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

        System.out.println(second_Largest_Element_In_Array(arr));

    }
}
