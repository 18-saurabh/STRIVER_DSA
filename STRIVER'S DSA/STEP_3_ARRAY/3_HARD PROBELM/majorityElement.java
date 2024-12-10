import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class majorityElement {
    public List<Integer> brute_majorityElementN3(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(ans.size()==0||ans.get(0)!=nums[i]){
                int cnt=0;
                for (int j=0;j<nums.length;j++){
                    if(nums[i]==nums[j]){
                        cnt++;
                    }
                }
                if(cnt>(nums.length/3)){
                    ans.add(nums[i]);
                }
            }
        }
        return ans;
    }
    
    public List<Integer> better_majorityElementN3(int[] nums){
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer>mpp=new HashMap<>();
        double n=Math.floor(nums.length/3);
        for(int i=0;i<nums.length;i++){
        mpp.put(nums[i],mpp.getOrDefault(nums[i], 0)+1);
        if (mpp.get(nums[i])==n) {
            ans.add(nums[i]);
        }
        }
        return ans;
    }
}
