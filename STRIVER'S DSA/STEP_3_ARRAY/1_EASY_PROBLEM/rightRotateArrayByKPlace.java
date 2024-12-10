import java.util.Scanner;

public class rightRotateArrayByKPlace {
    public static int[] right_Rotate_The_Array(int nums[], int k, int n) {
        int temp[] = new int[n]; // TC=(3K) //SC=O(N)
        for (int i = n - k; i < n; i++) {
            temp[i - (n - k)] = nums[i];
        }
        for (int i = k; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
        return nums;
    }

    public void rotate(int[] nums, int k) { // TC=O(N) //SC=O(1)
        int n = nums.length;
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);

    }

    public void reverse(int nums[], int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k");
        int k = sc.nextInt();
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
        int[] storage = new int[n];
        storage = right_Rotate_The_Array(arr, k, n);
        // Printing the elements of the array
        for (int i = 0; i < storage.length; i++) {
            System.out.print(storage[i] + " ");
        }
        sc.close();
    }
}
