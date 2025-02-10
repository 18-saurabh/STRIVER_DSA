public class _1_minimumBitFlipsToConvertANumber {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int cnt = 0;
        for (int i = 0; i <= 31; i++) {
            if ((ans & (1 << i)) != 0) { // Correct condition
                cnt++;
            }
        }
        return cnt;
    }
}
