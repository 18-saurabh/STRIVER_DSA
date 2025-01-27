public class _6_oddOrEven {

    static boolean isEven(int n) {
        if ((n & 1) == 0) {
            return true;
        }
        return false;
    }
}