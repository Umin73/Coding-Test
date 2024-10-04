package 백준;

import java.util.ArrayList;
import java.util.Scanner;

public class _15989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n = 0;
        int[][] dp = new int[10001][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 0; i < T; i++) {
            n = sc.nextInt();

            for(int j = 4; j <= n; j++) {
                if(dp[j][1] != 0) continue;
                dp[j][1] = dp[j-1][1];
                dp[j][2] = dp[j-2][1] + dp[j-2][2];
                dp[j][3] = dp[j-3][1] + dp[j-3][2] + dp[j-3][3];
            }

            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }
    }
}
