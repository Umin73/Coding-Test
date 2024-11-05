package SWEA.D2;

import java.util.Scanner;

public class SWEA_1954 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int row = n;
            int col = n;
            int num = 1;
            int r = 0;
            int c = 0;

            while(num <= n*n) {
                for(int i = 0; i < col; i++) {
                    arr[r][c] = num++;
                    c++;
                }
                col--; row--;
                r++; c--;

                for(int i = 0; i < row; i++) {
                    arr[r][c] = num++;
                    r++;
                }
                r--; c--;

                for(int i = 0; i < col; i++) {
                    arr[r][c] = num++;
                    c--;
                }
                col--; row--;
                r--; c++;

                for(int i = 0; i < row; i++) {
                    arr[r][c] = num++;
                    r--;
                }
                r++; c++;
            }

            System.out.println("#"+test_case);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
