import java.util.HashMap;
import java.util.Map;

public class _2_findNumberThatAppearsOddNumberOfTimes {
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

    public static int better_AppearingOnes(int a[]) {
        int n = a.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        // Populate the HashMap with values (assuming key = element, value = frequency)
        for (int i = 0; i < n; i++) {
            mpp.put(a[i], mpp.getOrDefault(a[i], 0) + 1);
        }

        for (int num : a) {
            if (mpp.get(num) == 1) {
                return num;
            }
        }
        return -1;
        
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

}
