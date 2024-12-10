import java.util.Scanner;

public class maximumConsecutiveOnes {
    public static int maxOnes(int a[]) {
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                cnt += 1;
                max = Math.max(max, cnt);
            } else {
                cnt = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements in your array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The elements in array are:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(maxOnes(arr));
        sc.close();
    }
}
