import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leadersInArray {
    public static List<Integer> bruteForce_superiorElements(int[] a) {
        int n = a.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // Loop through each element
        for (int i = 0; i < n; i++) {
            boolean isSuperior = true;

            // Compare with all elements to its right
            for (int j = i + 1; j < n; j++) {
                if (a[i] <= a[j]) {
                    isSuperior = false;
                    break; // If any element is greater, it's not superior
                }
            }

            // If it's superior, add to the result list
            if (isSuperior) {
                ans.add(a[i]);
            }
        }
        // Return the list of superior elements
        return ans;
    }

    public static List<Integer> Optimal_superiorElements(int[] a) {
        int n = a.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int maxi = a[n - 1];
        ans.add(maxi);
        // Loop through each element
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > maxi) {
                ans.add(a[i]);
                maxi = a[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}