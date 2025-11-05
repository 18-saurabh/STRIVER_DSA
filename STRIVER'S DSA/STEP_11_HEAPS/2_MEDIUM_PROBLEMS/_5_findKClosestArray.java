import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair<Key,Value>{
    Key key;
    Value value;
    Pair(Key key, Value value){
        this.key = key;
        this.value = value;
    }
    Key getKey(){
        return key;
    }
    Value getValue(){
        return value;
    }
}
public class _5_findKClosestArray {
  // ✅ 1️⃣ OPTIMAL — Max-Heap of size K (O(n log k))
    public List<Integer> findClosestElements_MaxHeap(int[] arr, int k, int x) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (!a.getKey().equals(b.getKey()))
                    return b.getKey() - a.getKey(); // larger distance first
                else
                    return b.getValue() - a.getValue(); // if same distance, larger number first
            }
        );

        for (int num : arr) {
            int diff = Math.abs(num - x);
            maxHeap.add(new Pair<>(diff, num));
            if (maxHeap.size() > k)
                maxHeap.poll(); // remove farthest element
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!maxHeap.isEmpty())
            ans.add(maxHeap.poll().getValue());

        Collections.sort(ans);
        return ans;
    }

    // ⚠️ 2️⃣ SIMPLER — Min-Heap with all elements (O(n log n))
    public List<Integer> findClosestElements_MinHeap(int[] arr, int k, int x) {
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a.getKey().equals(b.getKey()))
                    return a.getValue() - b.getValue(); // same distance → smaller number first
                else
                    return a.getKey() - b.getKey(); // smaller distance first
            }
        );

        for (int num : arr)
            minHeap.add(new Pair<>(Math.abs(num - x), num));

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k && !minHeap.isEmpty(); i++)
            ans.add(minHeap.poll().getValue());

        Collections.sort(ans);
        return ans;
    }

    // ✅ 3️⃣ MOST OPTIMAL — Binary Search (O(log(n - k) + k))
    public List<Integer> findClosestElements_BinarySearch(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = left; i < left + k; i++)
            ans.add(arr[i]);

        return ans;
    }

}
