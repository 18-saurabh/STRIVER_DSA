// import java.util.Scanner;

// public class reverseSubArray {
//     public static void main(String[] args) {
//         int start=0;
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter size of Array:");
//         int n = sc.nextInt();
//         int arr[] = new int[n];
//         System.out.println("Enter elements in Array:");
//         for (int i = 0; i <n; i++) {
//             arr[i] = sc.nextInt();
//         }
//         System.out.println("The numbers in Array are:");
//          for (int i = 0; i < n; i++) {
//             System.out.print(arr[i] + " ");
//         }
//         System.out.println();
//         System.out.println("Enter the number after which array would reversed");
//         int m=sc.nextInt();
//         // for(int i=0;i<m;i++){
//         //     System.out.print(arr[i]+" ");
//         // }
//         System.out.println("Array after "+m+" Index is :");
//         if(m==0){
//             int temp;
//             temp = arr[start];
//             arr[start] = arr[n - i - 1];
//             arr[n - i - 1] = temp;
//         }
//         for(int i=n-m;i<n;i++){
//             System.out.print(arr[i]+" ");
//         }
//     }
// }
