import java.util.Scanner;

public class longestSubArray {
    // Function to find the length of the longest subarray with sum K
    public static int brute_lenOfLongSubarr(int A[], int N, int K) {
        int len = 0; // Initialize length of the longest subarray
        for (int i = 0; i < A.length; i++) {
            int s = 0; // Initialize sum of the subarray starting at index i
            for (int j = i; j < A.length; j++) { // Loop through the array from i to the end
                s += A[j]; // Add the current element to the sum
                if (s == K) { // Check if the sum is equal to the desired sum K
                    len = Math.max(len, j - i + 1); // Update the maximum length
                }
            }
        }
        return len; // Return the length of the longest subarray with sum K
    }

    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int N = scanner.nextInt();

        // Creating the array
        int A[] = new int[N];

        // Taking input for the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Taking input for the desired sum K
        System.out.print("Enter the desired sum K: ");
        int K = scanner.nextInt();

        // Call the function and print the result
        int result = brute_lenOfLongSubarr(A, N, K);
        System.out.println("Length of the longest subarray with sum " + K + " is: " + result);
    }
}
