package SWEA.D2;

import java.util.Scanner;

public class SWEA_2001 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]arr = new int[n][n];
            int sum = 0;
            int tempSum = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<=n-m; i++) {
                for(int j=0; j<=n-m; j++) {
                    for(int k=i; k<i+m; k++) {
                        for(int l=j; l<j+m; l++) {
                            tempSum += arr[k][l];
                        }
                    }
                    if(tempSum > sum) sum = tempSum;
                    tempSum = 0;
                }
            }
            System.out.println("#" + test_case + " " +sum);
        }
    }
}
