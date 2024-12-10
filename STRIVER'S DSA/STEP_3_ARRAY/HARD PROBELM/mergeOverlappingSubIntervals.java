import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class mergeOverlappingSubIntervals {
     public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(!ans.isEmpty()&& end<=ans.get(ans.size()-1)[1]) continue;
            for(int j=i+1;j<n;j++){
                if(intervals[j][0]<=end){
                    end=Math.max(end,intervals[j][1]);
                }
                else {
                    break;
                }
            }
            ans.add(new int[]{start,end});
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public int[][] optimal_merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
        List<int[]>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.isEmpty()||intervals[i][0]>ans.get(ans.size()-1)[1]){
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }
            else{
                ans.get(ans.size()-1)[1]=Math.max( ans.get(ans.size()-1)[1],intervals[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
