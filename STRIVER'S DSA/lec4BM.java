import java.util.*;

public class lec4BM {

    private static final String N1 = null;

    public static void countDigit(int N) {
        // code here
        int cnt = 0;
        while (N > 0) {
            N = N / 10;
            cnt += 1;
        }
        System.out.println(cnt);
    }

    public static void reverse(int N) {
        // code here
        int reverse = 0;
        while (N != 0) {
            int L_Digit = N % 10;
            if (reverse > Integer.MAX_VALUE / 10 || reverse < Integer.MIN_VALUE / 10) {
                System.out.println("Wrong Input");
            }
            reverse = (reverse * 10) + L_Digit;
            N = N / 10;
        }
        System.out.println(reverse);

    }

    public static void checkPalindrome(int N) {
        int palindrome = N;
        int reverse = 0;
        while (N > 0) {
            int L_Digit = N % 10;
            reverse = (reverse * 10) + L_Digit;
            N = N / 10;
        }
        if (reverse == palindrome) {
            System.out.println("The entered number is a Palindrome");
        } else {
            System.out.println("The number is not a Palindrome");
        }
    }

    public static void isArmstrong(int N) {
        int digit = 0;
        int sum = 0;
        int armstrong = N;
        while (N > 0) {
            N = N / 10;
            digit += 1;
        }
        System.out.println("Number of digit is " + digit);
        int temp = armstrong;
        while (armstrong > 0) {
            int L_Digit = armstrong % 10;
            sum = (int) (sum + Math.pow(L_Digit, digit));
            armstrong = armstrong / 10;
        }
        if (sum == temp) {
            System.err.println("The number is armstrong");
        } else {
            System.out.println("The number is not a armstrong");
        }
    }

    public static void print_all_divisor(int N) {
        int sum = 0;
        System.out.println("All Divisors are:");
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                System.out.println(i + " ");
                sum = sum + i;
                if ((N / i) != i) {
                    System.out.println(N / i);
                }
            }
        }
        System.out.println("Sum of Divisors are:");
        System.out.println(sum);
    }

    public static void sumOfDivisors(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int temp = i;
            for (int j = 1; j <= i; j++) {
                if (temp % j == 0) {
                    sum = sum + j;
                }
            }
        }
        System.out.println(sum);
    }

    public class Solution {
        // Function to calculate the sum of divisors of a given number N.
        public long sumOfDivisors(int N) {
            long sum = 0;

            // Iterating from 1 to N.
            for (int i = 1; i <= N; i++) {
                // Calculating and accumulating the sum of divisors.
                sum += (N / i) * i;
            }

            // Returning the sum of divisors.
            return sum;
        }
    }

    public static void checkPrime(int N) {
        int temp = (int) Math.sqrt(N);
        int cnt = 0;
        for (int i = 1; i <= temp; i++) {
            if (N % i == 0) {
                cnt++;
                if (N / i != i)
                    cnt++;
            }
        }
        System.out.println(cnt);
        if (cnt == 2)
            System.out.println("The number is prime");
        else
            System.out.println("The number is not a prime");
    }

    public static void GCD(int N, int N1) {
        for (int i = Math.min(N, N1); i >= 1; i--) {
            if (N % i == 0 && N1 % i == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void EuclideanAlgorithm(int N, int N1) {
        while (N > 0 && N1 > 0) {
            if (N > N1)
                N = N % N1;
            else
                N1 = N1 % N;
        }
        if (N == 0)
            System.out.println(N1);
        else
            System.out.println(N);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int N = sc.nextInt();
        System.out.println("Enter a number 2"); // For GcD
        int N1 = sc.nextInt();
        checkPrime(N);
    }
}
