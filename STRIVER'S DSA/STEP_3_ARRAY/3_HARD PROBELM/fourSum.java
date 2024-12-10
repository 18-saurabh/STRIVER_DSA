import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class fourSum {
     public List<List<Integer>> brute_fourSum(int[] nums, int target) {
         int n = nums.length;
         Set<List<Integer>> st = new HashSet<>();
         for (int i = 0; i < n; i++) {
             for (int j = i + 1; j < n; j++) {
                 for (int k = j + 1; k < n; k++) {
                     for (int l = k + 1; l < n; l++) {
                         long sum = (nums[i] + nums[j]);
                         sum += nums[k];
                         sum += nums[l];
                         if (sum == target) {
                             List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                             temp.sort(null);
                             st.add(temp);
                         }
                     }
                 }
             }
         }
         List<List<Integer>> ans = new ArrayList<>(st);
         return ans;
    }
    
    public List<List<Integer>> better_fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer>hashSet=new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    int fourth = (int) (target - sum);
                    if(hashSet.contains(fourth)){
                        List<Integer>temp=Arrays.asList(nums[i],nums[j],nums[k],fourth);
                        temp.sort(null);
                        st.add(temp);
                    }
                    hashSet.add(nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    
    public List<List<Integer>> optimal_fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])  continue;
            for(int j=i+1;j<n;j++){
                if (j !=i+1 && nums[j] == nums[j- 1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum =nums[i]+nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if (sum==target) {
                        List<Integer>temp=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while (k<l && nums[k]==nums[k-1])k++;
                        while (k < l && nums[l] == nums[l + 1])l--;
                    }
                    else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
}