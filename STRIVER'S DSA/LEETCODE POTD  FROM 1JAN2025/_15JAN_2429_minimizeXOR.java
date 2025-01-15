public class _15JAN_2429_minimizeXOR {
    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }

    // Function to find the integer x
    public static int minimizeXor(int num1, int num2) {
        int setBits = countSetBits(num2); // Number of set bits required
        int x = 0;

        // Use the set bits of num1 to construct x
        for (int i = 31; i >= 0 && setBits > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                x |= (1 << i);
                setBits--;
            }
        }

        // If more set bits are needed, add them from the least significant bit
        for (int i = 0; i <= 31 && setBits > 0; i++) {
            if ((x & (1 << i)) == 0) {
                x |= (1 << i);
                setBits--;
            }
        }

        return x;
    }
}