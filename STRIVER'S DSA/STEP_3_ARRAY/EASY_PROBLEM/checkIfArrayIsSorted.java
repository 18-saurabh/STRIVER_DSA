import java.util.*;
public class checkIfArrayIsSorted {

    public static int check_if_array_is_sorted(int arr[]){
        int count=0;
        int previous_element=arr[0];
        for(int i=1;i<arr.length;i++){
             if(arr[i]>previous_element || arr[i]==previous_element){
                
             }
        }
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

        System.out.println(check_if_array_is_sorted(arr));

    }
}
