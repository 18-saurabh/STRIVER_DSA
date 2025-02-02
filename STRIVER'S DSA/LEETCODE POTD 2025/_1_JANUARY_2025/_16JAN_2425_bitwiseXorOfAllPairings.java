public class _16JAN_2425_bitwiseXorOfAllPairings {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int xor = 0;
        if (m % 2 != 0) {
            for (int num : nums1) {
                xor ^= num;
            }
        }
        if (n % 2 != 0) {
            for (int num : nums2) {
                xor ^= num;
            }
        }
        return xor;
    }
}