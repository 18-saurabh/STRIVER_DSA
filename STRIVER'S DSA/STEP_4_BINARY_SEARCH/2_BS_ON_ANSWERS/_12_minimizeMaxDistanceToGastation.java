import java.util.PriorityQueue;

public class _12_minimizeMaxDistanceToGastation {
    public static double brute_MinimiseMaxDistance(int[] arr, int K) {
        // Write your code here.
        int n = arr.length;
        int howMany[] = new int[n - 1];
        double maxAns = -1;
        for (int gasStation = 1; gasStation <= K; gasStation++) {
            double maxValue = -1;
            int maxIndex = -1;
            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (double) (howMany[i] + 1);
                if (sectionLength > maxValue) {
                    maxValue = sectionLength;
                    maxIndex = i;
                }
            }
            howMany[maxIndex]++;
        }
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (double) (howMany[i] + 1);
            maxAns = Math.max(sectionLength, maxAns);
        }
        return maxAns;
    }
    
  public static class pair{
    double first;
    int second;
    pair(double first,int second){
        this.first=first;
        this.second=second;
    }
  }
    
    public static double better_MinimiseMaxDistance(int[] arr, int K) {
        // Write your code here.
        int n = arr.length;
        int howMany[] = new int[n - 1];
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->Double.compare(b.first, a.first));
        for(int i=0;i<n-1;i++){
            pq.add(new pair(arr[i+1]-arr[i],i));
        }
        for (int gasStation = 1; gasStation <= K; gasStation++) {
            pair tp = pq.poll();
            int secInd=tp.second;
            howMany[secInd]++;
            double diff=arr[secInd+1]-arr[secInd];
            double sectionLength=diff/(double)howMany[secInd]+1;
            pq.add(new pair(sectionLength, secInd));
        }
        return pq.peek().first;
    }
}
