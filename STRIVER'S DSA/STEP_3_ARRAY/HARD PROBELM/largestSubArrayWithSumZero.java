import java.util.HashMap;
import java.util.Map;

public class largestSubArrayWithSumZero {
    public int lenOfLongestSubarr(int[] arr) {
        // code here
        Map<Integer,Integer>mpp=new HashMap<>();
        int maxi=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if (sum==0){
                maxi=i+1;
            }
            if(mpp.containsKey(sum-0)){
             maxi=Math.max(maxi,i-mpp.get(sum-0));
            }
            mpp.putIfAbsent(sum,i);
            }
        return maxi;
    }
}
