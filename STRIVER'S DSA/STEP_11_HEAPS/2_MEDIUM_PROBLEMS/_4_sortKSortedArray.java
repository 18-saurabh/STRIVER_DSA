import java.util.PriorityQueue;

public class _4_sortKSortedArray {
    public static int[] nearlySorted(int[] array, int n, int k) {
    int[] ans = new int[n];
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int index = 0;

    // Step 1: Add first k+1 elements
    for (int i = 0; i <= k && i < n; i++) {
        minHeap.add(array[i]);
    }

    // Step 2: Process remaining elements
    for (int i = k + 1; i < n; i++) {
        ans[index++] = minHeap.poll();
        minHeap.add(array[i]);
    }

    // Step 3: Extract remaining from heap
    while (!minHeap.isEmpty()) {
        ans[index++] = minHeap.poll();
    }

    return ans;
}

}
