import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair<Key, Value> {
    Key key;
    Value value;

    Pair(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }
}

public class _1_kMostFrequentElement {
    public int[] maxHeap_topKFrequent(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            maxHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }
        return result;
    }

    public int[] minHeap_topKFrequent(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            minHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }

        return result;
    }
}
