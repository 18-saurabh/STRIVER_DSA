import java.util.*;

public class lec5LBRecursion {
    static int cnt = 1;

    public static void infiniteRecursive() {
        if (cnt == 5)
            return;
        System.out.println(cnt);
        cnt++;
        infiniteRecursive();
    }

    public static void printNos(int N) {
        if (N > 0) {
            printNos(N - 1);
            System.out.println(N + " ");
        }
        return;
    }

    public static void printName(int i, int N) {
        if (i > N)
            return;
        System.out.print("GFG" + " ");
        printName(i + 1, N);
    }

    public static void printReverseNos(int i, int N) {
        if (i < 1)
            return;
        System.out.println(i);
        printReverseNos(i - 1, N);

    }

    public static void print_1toN_Nos_BT(int i, int N) {
        if (i < 1)
            return;
        print_1toN_Nos_BT(i - 1, N);
        System.out.println(i);
    }

    public static void print_Reverse_1toN_Nos_BT(int i, int N) {
        if (i > N)
            return;
        print_Reverse_1toN_Nos_BT(i + 1, N);
        System.out.println(i);
    }

    public static void f(int N) {
        if (N < 1)
            return;
        System.out.print(N + " ");
        f(N - 1);
    }

    public static int additionOfN_NaturalNumbers(int N) { // using recursion
        if (N == 0)
            return 0;
        return N + additionOfN_NaturalNumbers(N - 1);
    }

    public static int sumofNnaturalnumber(int N) { // Using direct formula non recursive
        if (N == 0)
        return 0;
        return (N * (N + 1) / 2);

    }

    public static long _cubeOfSumOfSeries(long N) { // using recursion
        if (N == 0)
            return 0;
        return (long) Math.pow(N, 3) + _cubeOfSumOfSeries(N - 1);
    }

    public static long cubeOfSumOfSeries(long N) { // using direct formula non recursive
        if (N == 0)
            return 0;
        long sumOfFirstNnaturalNumber = N * (N + 1) / 2;
        long a = (long) Math.pow(sumOfFirstNnaturalNumber, 2);
        return a;
    }

    public static int fact(int N){
        if(N==0) return 1;
        return N*fact(N-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int N = sc.nextInt();
        System.out.println(fact(N));
    }
}
