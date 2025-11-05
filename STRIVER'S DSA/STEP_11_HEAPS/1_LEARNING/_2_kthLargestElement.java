import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class _2_kthLargestElement {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        ArrayList<Integer>ans=new ArrayList<>(k);
        for(int num:arr){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        while(minHeap.size()>0){
            ans.add(minHeap.peek());
            minHeap.poll();
        }
        Collections.reverse(ans);
        return ans;
    }
}
