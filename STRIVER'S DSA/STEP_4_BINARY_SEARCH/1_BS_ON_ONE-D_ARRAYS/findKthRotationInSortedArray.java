import java.util.List;

public class findKthRotationInSortedArray {
    public int findKRotation(List<Integer> arr) {
        int ans = Integer.MAX_VALUE;
        int index = 0;
        int n = arr.size();
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(low) <= arr.get(high)) {
                if (arr.get(low) < ans) {
                    index = low;
                    ans = arr.get(low);
                }
                break;
            }
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) < ans) {
                    index = low;
                    ans = arr.get(low);
                }
                low = mid + 1;
            } else {
                high = mid - 1;
                if (arr.get(mid) < ans) {
                    index = mid;
                    ans = arr.get(mid);
                }
            }

        }
        return index;
    }
}
