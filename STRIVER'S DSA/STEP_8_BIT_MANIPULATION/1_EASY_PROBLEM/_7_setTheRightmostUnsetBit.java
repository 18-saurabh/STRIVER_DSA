public class _7_setTheRightmostUnsetBit {
    static int setBit(int n) {
        // code here
        int nums = n | (n + 1);
        return nums;
    }
}
