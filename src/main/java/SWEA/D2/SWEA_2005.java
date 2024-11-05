package SWEA.D2;
import java.util.Scanner;

public class SWEA_2005 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int [][]arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                if(i == 0) {
                    arr[0][0] = 1;
                } else {
                    arr[i][0] = 1;
                    arr[i][i] = 1;
                }
            }

            for(int i = 2; i < n; i++) {
                for(int j = 1; j < n - 1; j++) {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }

            System.out.println("#"+test_case);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < i+1; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
