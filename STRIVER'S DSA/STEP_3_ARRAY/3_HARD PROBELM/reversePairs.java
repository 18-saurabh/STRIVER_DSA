import java.util.ArrayList;
public class reversePairs {
    void merge(int nums[], int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else { // right is smaller
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }
    int mergeSort(int nums[], int low, int high) {
        int cnt=0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt+=mergeSort(nums, low, mid);
        cnt+=mergeSort(nums, mid + 1, high);
        cnt+=countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return cnt;
    }
    int countPairs(int nums[], int low, int mid, int high) {
        int cnt=0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2L * nums[right]) // Fixed overflow
                right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }
    public int optimal_reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
        
    }
}


