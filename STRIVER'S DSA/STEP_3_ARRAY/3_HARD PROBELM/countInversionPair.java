import java.util.ArrayList;

public class countInversionPair {
    static int brute_inversionCount(int arr[]) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[1] > arr[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int optimal_inversionCount(int arr[]) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }
    static int merge(int arr[], int low, int mid, int high) {
        int cnt = 0;
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            // right is smaller
            else {
                temp.add(arr[right]);
                cnt += (mid - left + 1);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt;
    }

    static int mergeSort(int arr[], int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }
}
