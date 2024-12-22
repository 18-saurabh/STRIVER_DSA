import java.util.Arrays;

public class _11_splitSubarrayMaximumSum {
     public int splitCount(int nums[],int splited){
        int split=1;
        int total=0;
        for(int i=0;i<nums.length;i++){
            if(total+nums[i]<=splited){
                total+=nums[i];
            }
            else{
                split++;
                total=nums[i];
            }
        }
        return split;
    }
    public int splitArray(int[] nums, int k) {
        if(k>nums.length) return -1;
        int low=Arrays.stream(nums).max().getAsInt();
        int high=Arrays.stream(nums).sum();
        while(low<=high){
            int mid=low+(high-low)/2;
            if(splitCount(nums,mid)<=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
