import java.util.PriorityQueue;

public class _7_minimumCostOfRopes {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = arr.length;

        if (n == 1) return 0;

        for (int x : arr) minHeap.add(x);

        int totalCost = 0;

        while (minHeap.size() > 1) {
            int num1 = minHeap.poll();
            int num2 = minHeap.poll();

            int sum = num1 + num2;
            totalCost += sum;

            minHeap.add(sum);
        }

        return totalCost;
    }
}
