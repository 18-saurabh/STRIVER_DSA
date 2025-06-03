public class _2_nextGreaterElement2 {
     public int[] brute_nextGreaterElements(int[] nums) {
        int n=nums.length;
        int nge[]=new int [n];
        for(int i=0;i<n;i++){
            nge[i]=-1;
            for(int j=1;j<n;j++){
                int ind=(i+j)%n;
                if(nums[ind]>nums[i]){
                    nge[i]=nums[ind];
                    break;
                }
            }
        }
        return nge;
    }
    
}