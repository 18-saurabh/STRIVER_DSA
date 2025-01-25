public class _4_bitManipulation {
    static void bitManipulation(int num, int i) {
        int getBit = (int) ((num >> (i - 1)) & 1);
        long setBit = num | (1L << (i - 1));
        long clearBit = num & ~(1L << (i - 1));
        System.out.print(getBit + " " + setBit + " " + clearBit);
    }
}
