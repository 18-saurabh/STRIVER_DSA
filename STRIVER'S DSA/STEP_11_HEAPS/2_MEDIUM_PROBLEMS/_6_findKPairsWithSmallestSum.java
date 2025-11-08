import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _6_findKPairsWithSmallestSum {
     // ---------------------------------------------
    // ✅ 1. Brute Force Greedy Solution (Slow)
    // ---------------------------------------------
    public List<List<Integer>> kSmallestPairsBrute(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> allPairs = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        // Generate all pairs
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int sum = nums1[i] + nums2[j];
                allPairs.add(new int[]{sum, nums1[i], nums2[j]});
            }
        }

        // Sort based on sum
        Collections.sort(allPairs, (a, b) -> Integer.compare(a[0], b[0]));

        // Take first k pairs
        for (int i = 0; i < k && i < allPairs.size(); i++) {
            res.add(Arrays.asList(allPairs.get(i)[1], allPairs.get(i)[2]));
        }

        return res;
    }


    // ---------------------------------------------
    // ✅ 2. Optimal Solution Using Min Heap (Fast)
    // ---------------------------------------------
    public List<List<Integer>> kSmallestPairsOptimal(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])  // compare by sum
        );

        List<List<Integer>> res = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        // Push first k pairs: nums1[i] with nums2[0]
        for (int i = 0; i < Math.min(k, n1); i++) {
            minHeap.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Process k smallest pairs
        while (k > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int sum = cur[0];
            int i = cur[1];
            int j = cur[2];

            res.add(Arrays.asList(nums1[i], nums2[j]));

            // Push next pair in same row
            if (j + 1 < n2) {
                minHeap.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }

            k--;
        }

        return res;
    }
}
