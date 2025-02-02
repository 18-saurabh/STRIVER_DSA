public class _17JAN_2683_neighboringBitwiseXOR {
    public boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0;
        for (int num : derived) {
            xorSum ^= num;
        }
        return xorSum == 0;
    }
}
