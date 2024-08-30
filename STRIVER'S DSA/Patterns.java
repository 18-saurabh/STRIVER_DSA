import java.util.*;
public class Patterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int r = sc.nextInt();
        // System.out.println("Enter number of columns");
        // int c = sc.nextInt();
        // pattern_18(r);
        pattern_1(r);
    }

    public static void pattern_1(int r) {             //pattern1
        for (int i = 0; i < r; i++) {                 //https://static.takeuforward.org/wp/uploads/2022/08/P1.png
            for (int j = 0; j < r; j++) {            
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void pattern_2(int r) {             //pattern2
        for (int i = 0; i < r; i++) {                // https://static.takeuforward.org/wp/uploads/2022/08/P2.png
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    } 

    public static void pattern_3(int r) {             //pattern3
        for (int i = 0; i <= r; i++) {                // https://static.takeuforward.org/wp/uploads/2022/08/P3.png
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    public static void pattern_4(int r) {             //pattern4
        for (int i = 0; i <= r; i++) {                 //https://static.takeuforward.org/wp/uploads/2022/08/P4.png   
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    public static void pattern_5(int r) {             //pattern5
        for (int i = 1; i <= r; i++) {                // https://static.takeuforward.org/wp/uploads/2022/08/P5.png
            for (int j = 0; j < r - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern_6(int r) {             //pattern6
        for (int i = 1; i <= r; i++) {                //https://static.takeuforward.org/wp/uploads/2022/08/P6.png
            for (int j = 1; j <=r - i + 1; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void pattern_7(int r) {             //pattern7
        for (int i = 0; i < r; i++) {                 // https://static.takeuforward.org/wp/uploads/2022/08/P7.png
            // space1
            for (int j = 0; j < r - i - 1; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // space2
            for (int j = 0; j < r - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern_8(int r) {             //pattern8
        for (int i = 0; i < r; i++) {                 // https://static.takeuforward.org/wp/uploads/2022/08/P8.png
            // space1
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 0; j < 2 * (r - i) - 1; j++) {
                System.out.print("*");
            }
            // space2
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern_9(int r) {             //pattern9
        //1st part                                    //https://static.takeuforward.org/wp/uploads/2022/08/P9.png
        for (int i = 0; i < r; i++) { 
            // space1
            for (int j = 0; j < r - i - 1; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // space2
            for (int j = 0; j < r - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        //2nd part
        for (int i = 0; i < r; i++) { 
            // space1
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 0; j < 2 * (r - i) - 1; j++) {
                System.out.print("*");
            }
            // space2
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern_10(int r) {            //pattern10
        for (int i = 1; i <= 2 * r - 1; i++) {        // https://static.takeuforward.org/wp/uploads/2022/08/P10.png
            int star = i;
            if (i > r)
                star = 2 * r - i;
            for (int j = 1; j <= star; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern_11(int r) {            //pattern11
        int start = 1;                                //https://static.takeuforward.org/wp/uploads/2022/08/P11.png
        for (int i = 0; i < r; i++) {
            if (i % 2 == 0)
                start = 1;
            else
                start = 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

    public static void pattern_12(int r) {            //pattern12
        for (int i = 1; i <= r; i++) {                // https://static.takeuforward.org/wp/uploads/2022/08/P12.png
            // number
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // space
            for (int j = 1; j <= 2 * (r - i); j++) {
                System.out.print(" ");
            }
            // number
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern_13(int r) {            //pattern13
        int num = 1;                                  //https://static.takeuforward.org/wp/uploads/2022/08/P13.png
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num += 1;
            }
            System.out.println();
        }
    }

    public static void pattern_14(int r) {            //pattern14
        for (int i = 0; i < r; i++) {                 // https://static.takeuforward.org/wp/uploads/2022/08/P14.png
            for (char ch = 'A'; ch <= 'A' + i; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void pattern_15(int r) {            //pattern15
        for (int i = 0; i < r; i++) {                 //https://static.takeuforward.org/wp/uploads/2022/08/P15.png
            for (char ch = 'A'; ch <= 'A' + r - i - 1; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void pattern_16(int r) {            //pattern16
        for (int i = 0; i < r; i++) {                 //https://static.takeuforward.org/wp/uploads/2022/08/P16.png
            char ch = 'A';
            if (i <= r)
                ch += i;
            for (int j = 0; j <= i; j++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static void pattern_17(int r) {            //pattern17
        for (int i = 0; i < r; i++) {                 //https://static.takeuforward.org/wp/uploads/2022/08/P17.png
            // space
            for (int j = 0; j < r - i - 1; j++) {
                System.out.print(" ");
            }
            // character
            char ch = 'A';
            int breakpoint = (2 * i + 1) / 2;
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print(ch);
                if (j <= breakpoint)
                    ch++;
                else
                    ch--;
            }
            // space
            for (int j = 0; j < r - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern_18(int r) {            //pattern18
        for (int i = 0; i < r; i++) {                 //https://static.takeuforward.org/wp/uploads/2022/08/P18.png
            char ch = 'A';
            ch += (r - i - 1);
            for (int j = 0; j <= i; j++) {
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }

    public static void pattern_19(int r) {            //pattern19
        int space = 0;                              //https://static.takeuforward.org/wp/uploads/2022/08/P19.png
        // part 1
        for (int i = 0; i < r; i++) {
            // star
            for (int j = 0; j < r - i; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j < r - i; j++) {
                System.out.print("*");
            }
            space += 2;
            System.out.println();
        }
        // part 2
        for (int i = 0; i < r; i++) {
            // star
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j < 2 * (r - i - 1); j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            space += 2;
            System.out.println();
        }
    }

    public static void pattern_20(int r) {            //pattern20
        int space = 2 * r - 2;
        for (int i = 1; i <= (2 * r) - 1; i++) {
            // star
            int star = i;
            if (i > r)
                star = 2 * r - i;
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            System.out.println();
            if (i < r)
                space -= 2;
            else
                space += 2;
        }
    }
 
    public static void pattern_21(int r) {            //pattern21
        for (int i = 0; i < r; i++) {                 //https://static.takeuforward.org/wp/uploads/2023/01/Screenshot-2023-01-02-at-1.54.55-PM-1.jpg
            for (int j = 0; j < r; j++) {
                if (i == 0 || i == r - 1 || j == 0 || j == r - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_22(int r) {             //pattern22
                                                      //https://static.takeuforward.org/wp/uploads/2022/08/P22.png

    }
}