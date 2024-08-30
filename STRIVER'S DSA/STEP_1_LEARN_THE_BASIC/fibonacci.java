import java.util.Scanner;
public class fibonacci {
    public static int c_fibonacci(int n) {
        if (n <= 1)
            return n;
        int last_digit = c_fibonacci(n - 1);
        int s_last_digit = c_fibonacci(n - 2);
        return (last_digit + s_last_digit);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n th term to get fibonacci");
        int n = sc.nextInt();
        System.out.println(c_fibonacci(n));
    }
}
