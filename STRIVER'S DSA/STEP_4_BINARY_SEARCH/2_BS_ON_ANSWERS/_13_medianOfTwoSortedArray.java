import java.util.ArrayList;

public class _13_medianOfTwoSortedArray {
    public double brute_findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        ArrayList<Integer> nums3 = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                nums3.add(nums1[i]);
                i++;
            } else {
                nums3.add(nums2[j]);
                j++;
            }
        }
        while (i < n) {
            nums3.add(nums1[i]);
            i++;
        }
        while (j < m) {
            nums3.add(nums2[j]);
            j++;
        }
        int N = n + m;
        if (N % 2 == 1) {
            return (double) nums3.get(N / 2);
        }
        double median = ((double) nums3.get(N / 2) + (double) nums3.get((N / 2) - 1)) / 2;
        return median;
    }

    public double better_findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int N = n + m;
        int i = 0;
        int j = 0;
        int index2 = N / 2;
        int index1 = (N / 2) - 1;
        int cnt = 0;
        int index1El = -1;
        int index2El = -1;

        // Merging both arrays partially until we reach the middle elements
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                if (cnt == index1)
                    index1El = nums1[i];
                if (cnt == index2)
                    index2El = nums1[i];
                cnt++;
                i++;
            } else {
                if (cnt == index1)
                    index1El = nums2[j];
                if (cnt == index2)
                    index2El = nums2[j];
                cnt++;
                j++;
            }
        }

        // Handle remaining elements from nums1
        while (i < n) {
            if (cnt == index1)
                index1El = nums1[i];
            if (cnt == index2)
                index2El = nums1[i];
            cnt++;
            i++;
        }

        // Handle remaining elements from nums2
        while (j < m) {
            if (cnt == index1)
                index1El = nums2[j];
            if (cnt == index2)
                index2El = nums2[j];
            cnt++;
            j++;
        }

        // Return median based on whether the total number of elements is odd or even
        if (N % 2 == 1) {
            return (double) index2El;
        }

        return (double) ((double) (index1El + index2El)) / 2.0;
    }
}
