import java.util.HashMap;
import java.util.Map;

public class _1_subarrayWithKDistinctIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);

    }
    public int atMost(int nums[],int k){
        int n=nums.length;
        int l=0;
        int r=0;
        int cnt=0;
        Map<Integer,Integer>mpp=new HashMap<>();
        while(r<n){
            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
            while(mpp.size()>k){
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0){
                    mpp.remove(nums[l]);
                }
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
    public int bruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int j = i; j < n; j++) {
                freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
                if (freqMap.size() == k) {
                    count++;
                } else if (freqMap.size() > k) {
                    break;
                }
            }
        }
        return count;
    }
}

