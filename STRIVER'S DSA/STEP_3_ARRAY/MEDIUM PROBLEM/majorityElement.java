import java.util.*;;
public class majorityElement {
    public static int brute_Major_Element(int nums[]) {
        int mid = (nums.length / 2); // Correct calculation of mid
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0; // Reset cnt for each element
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    cnt++;
                }
                if (cnt > mid) {
                    return nums[i]; // Return the element if it appears more than mid times
                }
            }
        }
        return -1; // Return -1 if no majority element is found (not likely if input is valid)
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Initialize the array and read elements
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
  
        System.out.println(brute_Major_Element(nums));
        scanner.close();
        
    }
}
