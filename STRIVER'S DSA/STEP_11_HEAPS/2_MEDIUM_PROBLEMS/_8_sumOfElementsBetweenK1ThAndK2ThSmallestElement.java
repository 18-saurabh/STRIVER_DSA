import java.util.PriorityQueue;

public class _8_sumOfElementsBetweenK1ThAndK2ThSmallestElement {
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>(); // Use Long wrapper class
        for (int i = 0; i < N; i++) { // Use int for loop counter as it's typically sufficient for array indices
            minHeap.add(A[i]); // Autoboxing handles long to Long conversion
        }

        // Discard K1 smallest elements
        for (int i = 0; i < K1; i++) {
            minHeap.poll();
        }

        long sum = 0;
        // Sum elements between K1-th and K2-th smallest
        // There are (K2 - 1) - K1 elements to sum
        for (int i = 0; i < (K2 - K1 - 1); i++) {
            sum += minHeap.poll();
        }
        return sum;
    }
}
