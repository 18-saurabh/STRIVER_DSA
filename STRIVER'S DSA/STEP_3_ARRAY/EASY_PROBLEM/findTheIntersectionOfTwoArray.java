import java.util.ArrayList;
import java.util.Scanner;

public class findTheIntersectionOfTwoArray {
    public static ArrayList<Integer> bruteIntersection(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> intersect = new ArrayList<>(); // T.C=O(N*M) S.C=O(M)
        int visited[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j] && visited[j] == 0) { // agar array 1 ka value aray 2 ke barabar hai to or wo
                                                             // visit nhi hua hai to add krnege intersect mein
                    intersect.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }
                if (arr2[j] > arr1[i]) {
                    break;
                }
            }
        }
        return intersect;
    }

    public static ArrayList<Integer> optimalIntersect(int a[],int b[],int n,int m){
           ArrayList<Integer>intersect=new ArrayList<>();               //T.C=O(N+M)     SC=O(1)
           int i=0,j=0;
           while(i<n && j<m){
            if(a[i]>b[j]){
                j++;
            }
            else if(a[i]<b[j]){
                i++;
            }
            else{
                intersect.add(a[i]);
                i++;
                j++;
            }
           }
           return intersect;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get the size of the first array from the user
        System.out.print("Enter the number of elements in the first array: ");
        int n = scanner.nextInt();
        int[] arr_1 = new int[n];

        // Get the elements of the first array from the user
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n; i++) {
            arr_1[i] = scanner.nextInt();
        }

        // Get the size of the second array from the user
        System.out.print("Enter the number of elements in the second array: ");
        int m = scanner.nextInt();
        int[] arr_2 = new int[m];

        // Get the elements of the second array from the user
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < m; i++) {
            arr_2[i] = scanner.nextInt();
        }

        ArrayList<Integer> storage = optimalIntersect(arr_1, arr_2, n, m);
        for (int i : storage) {
            System.out.print(i + " ");
        }
        scanner.close();
    }
}
