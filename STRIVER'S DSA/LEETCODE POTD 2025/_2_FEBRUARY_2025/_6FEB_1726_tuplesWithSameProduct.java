import java.util.HashMap;

public class _6FEB_1726_tuplesWithSameProduct {
    public int tupleSameProduct(int[] nums) {
        // HashMap<Integer, Integer> ans = new HashMap<>();
        // int n = nums.length;
        // int result = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int product = nums[i] * nums[j];
        //         ans.put(product, ans.getOrDefault(product, 0) + 1);
        //     }
        // }
        // for (int count : ans.values()) {
        //     if (count > 1) {
        //         for (int i = 0; i < count; i++) {
        //             for (int j = i + 1; j < count; j++) {
        //                 result += 8;
        //             }
        //         }
        //     }
        // }
        // return result;
        HashMap<Integer,Integer>counter=new HashMap<>();
        int n=nums.length;
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int product=nums[i]*nums[j];
                if(counter.containsKey(product)){
                    int cnt=counter.get(product);
                    result+=cnt*8;
                }
                counter.put(product,counter.getOrDefault(product,0)+1);
            }
        }
        return result;
    }
}