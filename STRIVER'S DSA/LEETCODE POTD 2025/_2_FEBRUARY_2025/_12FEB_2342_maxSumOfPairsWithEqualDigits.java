import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _12FEB_2342_maxSumOfPairsWithEqualDigits {
     public static int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int maxSum = -1;
        
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            
            map.putIfAbsent(digitSum, new PriorityQueue<>());
            PriorityQueue<Integer> pq = map.get(digitSum);
            pq.offer(num);
            
            if (pq.size() > 2) {
                pq.poll(); // Keep only the top 2 max elements
            }
        }
        
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() == 2) {
                int num1 = pq.poll();
                int num2 = pq.poll();
                maxSum = Math.max(maxSum, num1 + num2);
            }
        }
        
        return maxSum;
    }
    
    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
