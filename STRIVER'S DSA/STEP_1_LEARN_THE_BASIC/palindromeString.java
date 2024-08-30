import java.util.Scanner;

public class palindromeString {

    public static Boolean check_palindrome_string(int i, String s) {
        if (i >= s.length()) {
            System.out.println("The String is Palindrome");
            return true;
        }
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            System.out.println("The given String is not palindrome");
            return false;
        }
        return check_palindrome_string(i + 1, s);
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String to check it is palindrome or not");
        String s = sc.next();
        System.out.println("The String you enetered is: " + s);
        System.out.println(check_palindrome_string(0, s));
    }
}
