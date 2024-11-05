package SWEA.D2;

import java.util.Scanner;

public class SWEA_1979 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 세로
                    if(arr[i][j] == 0) continue;
                    if((i > 0 && arr[i-1][j] == 0) || i == 0) {
                        if(i + k-1 < n) {
                            int idx = i;
                            for(; idx < i+k; idx++) {
                                if(arr[idx][j] == 0) break;
                            }
                            if(idx == i + k) {
                                if(idx == n || arr[idx][j] == 0) cnt++;
                            }
                        }
                    }

                    // 가로
                    if((j > 0 && arr[i][j-1] == 0) || j == 0) {
                        if(j + k-1 < n) {
                            int idx = j;
                            for(; idx < j+k; idx++) {
                                if(arr[i][idx] == 0) break;
                            }
                            if( idx == j + k) {
                                if(idx == n || arr[i][idx] == 0) cnt++;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}
