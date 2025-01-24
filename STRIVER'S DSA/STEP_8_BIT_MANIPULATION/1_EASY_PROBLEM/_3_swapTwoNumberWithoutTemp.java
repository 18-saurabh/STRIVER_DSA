import java.util.ArrayList;
import java.util.List;

public class _3_swapTwoNumberWithoutTemp {
    static List<Integer> get(int a, int b) {
        // code here
        ArrayList<Integer> store = new ArrayList<>();
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        store.add(a);
        store.add(b);
        return store;
    }
}
