import java.util.Arrays;

public class mergeTwoSortedArrayWithoutExtraSpace {
    public static void SortTwoArray(int nums1[],int nums2[],int m,int n){
        int nums3[]=new int[m+n];
        int left=m-1;
        int right=0;
        while (left>=0 && right<n) {
            if (nums1[left]>nums2[right]) {
                swap(nums1[left], nums2[right]);
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i=0;i<n+m;i++){
            if (i < m)
                nums1[i] = nums3[i];
            else
                nums2[i - m] = nums3[i];
        }
    }
    public static void swap(int nums1,int nums2){
                int temp=nums1;
                nums1=nums2;
                nums2=temp;
        }
}

