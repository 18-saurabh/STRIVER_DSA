import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

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

    public static int better_lenOfSubarr(int A[], int N, long K) { // for positive and negative number in array
        // Declare a HashMap to store prefix sums and their indices
        Map<Long, Integer> prefixSum = new HashMap<>();
        int maxLen = 0;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += A[i]; // Update the current sum

            // Check if the sum itself is equal to K
            if (sum == K) {
                maxLen = Math.max(maxLen, i + 1); // Update maxLen if the entire subarray from the start sums to K
            }

            // Calculate the remainder that would need to exist in the map
            long rem = sum - K;

            // Check if this remainder has been seen before
            if (prefixSum.containsKey(rem)) {
                int len = i - prefixSum.get(rem); // Calculate the length of the subarray
                maxLen = Math.max(maxLen, len); // Update maxLen if this subarray is longer
            }

            // If the current sum has not been seen before, add it to the map
            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }

        return maxLen; // Return the length of the longest subarray with sum K
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
        int result = better_lenOfSubarr(A, N, K);
        System.out.println("Length of the longest subarray with sum " + K + " is: " + result);
        scanner.close();
    }
}
