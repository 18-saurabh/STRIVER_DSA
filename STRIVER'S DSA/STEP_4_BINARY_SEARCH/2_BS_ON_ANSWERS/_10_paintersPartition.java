import java.util.ArrayList;
import java.util.Collections;
public class _10_paintersPartition {
    public static int countPainters(ArrayList<Integer> boards, int unit) {
        int painters = 1;
        int paintedBoards = 0;
        for (int i = 0; i < boards.size(); i++) {
            if (paintedBoards + boards.get(i) <= unit) {
                paintedBoards += boards.get(i);
            } else {
                painters++;
                paintedBoards = boards.get(i);
            }
        }
        return painters;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        if (k > boards.size())
            return -1;
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countPainters(boards, mid) <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

