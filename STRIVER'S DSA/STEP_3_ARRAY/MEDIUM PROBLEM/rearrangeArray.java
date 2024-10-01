public class rearrangeArray {
    public int[] bruteRearrangeArray(int[] nums) {
        int n = nums.length;
        int pos[] = new int[n / 2];
        int neg[] = new int[n / 2];
        int posIndex = 0;
        int negIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pos[posIndex++] = nums[i];
            } else if (nums[i] < 0) {
                neg[negIndex++] = nums[i];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = pos[i];
            nums[(2 * i) + 1] = neg[i];
        }
        return nums;
    }
    
    public int[] optimalRearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else if (nums[i] < 0) {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return ans;
    }
}
