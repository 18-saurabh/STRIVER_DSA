import java.util.Scanner;

public class largestElementInArray {
    public static int largest_Element_In_Array(int arr[]) {
        int largest_element=arr[0];                         //T.C=O(N)
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest_element){
                largest_element=arr[i];
            }
        }
        System.out.println("Largest Element in array is");
        return largest_element;

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

        System.out.println(largest_Element_In_Array(arr));


    }
}