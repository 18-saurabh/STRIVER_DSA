import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class subArrayWithGivenXOR {
    public int brute_solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                for (int k = i; k <= j; k++) {
                    xor = xor ^ A.get(k);
                }
                if (xor == B) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int better_solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor = xor ^ A.get(j);
                if (xor == B) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int optimal_solve(ArrayList<Integer> A, int B) {
        int xr = 0;
        int cnt = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1); // Initializes map with key=0 and value=1
        for (int i = 0; i < A.size(); i++) {
            xr = xr ^ A.get(i);
            int x = xr ^ B; // Calculate the target XOR value
            cnt += mpp.getOrDefault(x, 0); // If 'x' is found in the map, add its count to 'cnt', otherwise add 0
            mpp.put(xr, mpp.getOrDefault(xr, 0) + 1); // Increment the count of current XOR value in the map
        }
        return cnt;
    }
}
