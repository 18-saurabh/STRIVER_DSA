import java.util.ArrayList;
import java.util.List;

public class _1_generateBinaryNumbers {
        public static List<String> generateBinaryNumbers(int n) {
        // Write your code here
        ArrayList<String> store = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder res = new StringBuilder();
            int num = i;
            while (num > 0) {
                if (num % 2 == 1)
                    res.append(1);
                else
                    res.append(0);
                num /= 2;
            }
            store.add(res.reverse().toString());
        }
        return store;
    }
}