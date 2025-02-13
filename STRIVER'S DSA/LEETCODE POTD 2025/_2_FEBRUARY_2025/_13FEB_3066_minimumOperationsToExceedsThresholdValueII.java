import java.util.PriorityQueue;

public class _13FEB_3066_minimumOperationsToExceedsThresholdValueII {
     public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        // Add all elements to the min heap
        for (int num : nums) {
            minHeap.add((long) num); // Use long to prevent overflow
        }

        int operations = 0;

        // Continue operations until the smallest element is >= k
        while (minHeap.peek() < k) {
            // Ensure at least two elements exist before polling
            if (minHeap.size() < 2) break;

            // Extract the two smallest elements
            long x = minHeap.poll();
            long y = minHeap.poll();

            // Perform the given operation
            long newElement = (x * 2) + y;

            // Add the new element back to the heap
            minHeap.add(newElement);

            // Increment the operation count
            operations++;
        }

        return operations;
    } 
}
