import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class twoSum {
    public static int[] two_Sum(int[] nums, int target) {
        // HashMap banao jahan number aur uski index store hogi
        Map<Integer, Integer> sumMap = new HashMap<>();

        // Array ke har element ko check karo
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i]; // Current number ko 'a' kehte hain
            int rem = target - a; // Target tak pahunchnay ke liye kitni aur value chahiye

            // Check karo agar rem value pehle se map mein hai
            if (sumMap.containsKey(rem)) {
                // Agar haan, to indices return karo
                return new int[] { sumMap.get(rem), i };
            }

            // Agar rem value map mein nahi hai, to current number aur index ko map mein add
            // karo
            if (!sumMap.containsKey(a)) {
                sumMap.put(a, i);
            }
        }

        // Agar koi solution nahi milta, to {-1, -1} return karo
        return new int[] { -1, -1 };
    }

    public static String read(int n, int[] book, int target) {
        // HashMap banate hain jo value aur unki index ko store karega
        Map<Integer, Integer> sumMap = new HashMap<>();

        // Array ke har element ke liye loop chalate hain
        for (int i = 0; i < book.length; i++) {
            int a = book[i]; // Current element ko 'a' kehte hain
            int rem = target - a; // Target ko achieve karne ke liye hume kitni value chahiye

            // Check karte hain agar ye remainder already map mein hai
            if (sumMap.containsKey(rem)) {
                // Agar haan, to "YES" return karte hain
                return ("YES");
            }

            // Agar remainder map mein nahi hai, to current element ko map mein add karte
            // hain
            if (!sumMap.containsKey(a)) {
                sumMap.put(a, i);
            }
        }

        // Agar loop ke end tak target sum nahi milta, to "NO" return karte hain
        return ("NO");
    }

    public static String optimal_Two_Sum(int arr[],int target){
        int len=arr.length;
        int i=0;
        int j=arr[len-1];
        bubbleSort(arr);
        while(i<j){
            if(arr[i]+arr[j]>target){
                j--;
            }
            else if(arr[i]+arr[j]<target){
                i++;
            }
            else{
                return ("Yes");
            }
        }
        return ("No");
    }
    
    // Bubble Sort function
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped)
                break;
        }
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
        
        // Read the target value
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();
        
        // Call the twoSum method
        int[] result = two_Sum(nums, target);
        
        // Print the result
        if (result[0] == -1) {
            System.out.println("No two sum solution");
        } else {
            System.out.println("Indices of the two numbers are: " + result[0] + " and " + result[1]);
        }
        scanner.close();

        System.out.println(optimal_Two_Sum(nums, target));
    }

}