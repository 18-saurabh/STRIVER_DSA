import java.util.Scanner;

public class findMissingNumberInArray {

    public static int better_missingNumber(int arr[],int n){
        int sum_1=0;
        int sum_2=0;
        for(int i=0;i<n+1;i++){
            sum_1+=i;
        }
        for(int i=0;i<n;i++){
            sum_2+=arr[i];
        }
        int difference = sum_1-sum_2;
        return  difference;
    }

    public static int bruteMissingNumber(int arr[]){
        //T.C =N*N   S.C=O(1)
        for(int i=1;i<=arr.length;i++){
            int flag = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==i){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                return i;
            }
        }
        return 1;
    }

    public static int optimal_missingNumber(int arr[], int n) {
        int sum_1 = n*(n+1)/2;
        int sum_2 = 0;
        
        for (int i = 0; i < n; i++) {
            sum_2 += arr[i];
        }
        int difference = sum_1 - sum_2;
        return difference;
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
        System.out.println(optimal_missingNumber(arr, n));

    }
}
