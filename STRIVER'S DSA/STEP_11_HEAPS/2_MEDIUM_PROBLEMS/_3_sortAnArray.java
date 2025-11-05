import java.util.PriorityQueue;

public class _3_sortAnArray {
    public int[] sortArray(int[] nums) {
        // Arrays.sort(nums);
        // return nums;
        int n=nums.length;
        int ans[]=new int[n];
        PriorityQueue<Integer>minHeap=new PriorityQueue<>(n);
        for(int num:nums){
            minHeap.add(num);
        }
        int i=0;
        while(!minHeap.isEmpty()){
            ans[i++]=minHeap.poll();
        }
        return ans;
    }
}
