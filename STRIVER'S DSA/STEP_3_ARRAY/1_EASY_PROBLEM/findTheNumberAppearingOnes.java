import java.util.Scanner;

public class findTheNumberAppearingOnes {

    public static int brute_AppearingOnes(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int cnt = 0; // Reset 'cnt' for each new element
            int num = a[i]; // Current element to check
            for (int j = 0; j < a.length; j++) {
                if (a[j] == num) {
                    cnt++; // Increment count if match is found
                }
            }
            if (cnt == 1) {
                return num; // Return the element if it appears exactly once
            }
        }
        return 0; // Return 0 if no unique element is found
    }

    public static int optimal_AppearingOnes(int nums[]) {
        int xor = 0; // Initialize a variable 'xor' to 0. This will hold the result of XOR
                     // operations.

        // Loop through each number in the array
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i]; // Apply XOR between 'xor' and the current element 'nums[i]'
        }

        return xor; // Return the result after all XOR operations are done
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
        System.out.println(brute_AppearingOnes(arr));
        sc.close();
    }
}
