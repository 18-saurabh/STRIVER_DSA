import java.util.ArrayList;
public class findRepeatingAndMissingNumbers {
    ArrayList<Integer> brute_findTwoElement(int arr[]) {
        // code here
        int repeating = -1;
        int missing = -1;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= arr.length; i++) {
            int cnt = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    cnt++;
                }
            }
            if (cnt == 2) {
                repeating = i;
            } else if (cnt == 0) {
                missing = i;
            }
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        ans.add(repeating);
        ans.add(missing);
        return ans;
    }

    ArrayList<Integer> better_findTwoElement(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length; // size of the array
        int[] hash = new int[n + 1]; // hash array

        // update the hash array:
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        // Find the repeating and missing number:
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2)
                repeating = i;
            else if (hash[i] == 0)
                missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        ans.add(repeating);
        ans.add(missing);
        return ans;
    }

    ArrayList<Integer> optimal_findTwoElement(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        long n = arr.length;
        long sn = (n * (n + 1)) / 2;
        long s2n = (n * (n + 1) * (2 * n + 1)) / 6;
        long s = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            s2 += (long) arr[i] * arr[i];
        }
        long val1 = s - sn; // Difference in sum: x - y
        long val2 = s2 - s2n; // Difference in sum of squares: x^2 - y^2
        val2 = val2 / val1; // x + y
        long x = (val1 + val2) / 2; // x = (val1 + val2) / 2
        long y = x - val1; // y = x - val1
        ans.add((int) x);
        ans.add((int) y);
        return ans;
    }

}
