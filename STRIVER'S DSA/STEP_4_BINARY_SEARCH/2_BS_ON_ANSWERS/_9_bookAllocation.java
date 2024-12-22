import java.util.ArrayList;
import java.util.Collections;

public class _9_bookAllocation {
    public static int countPages(ArrayList<Integer> arr, int pages) {
        int student = 1;
        int pagesStudent = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                pagesStudent += arr.get(i);
            } else {
                student++;
                pagesStudent = arr.get(i);
            }
        }
        return student;

    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) {
            return -1;
        }
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        for (int pages = low; pages <= high; pages++) {
            if (countPages(arr, pages) == m) {
                return pages;
            }
        }
        return -1;
    }
    
    public static int optimal_findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) {
            return -1;
        }
        int result=0;
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low<=high) {
            int mid=(low+high)/2;
            if (countPages(arr, mid)<=m) {
                result=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

       return result;
    }
}
