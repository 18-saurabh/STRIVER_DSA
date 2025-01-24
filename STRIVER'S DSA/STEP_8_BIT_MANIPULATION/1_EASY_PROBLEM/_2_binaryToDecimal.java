public class _2_binaryToDecimal {
    public static int convert(int N, String str) {
        // Write your code here
        int p2 = 1;
        int num = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (str.charAt(i) == '1')
                num = num + p2;

            p2 = p2 * 2;
        }
        return num;

    }
}