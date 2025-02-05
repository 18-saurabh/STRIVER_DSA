public class _9_divideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0);
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;
        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++; // Find the maximum power of divisor that fits
            }
            ans += 1 << cnt;
            n -= d * (1 << cnt);
        }
        return sign ? ans : -ans;
    }
}
