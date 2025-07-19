package 알고리즘.DP;

import java.io.*;

public class _9251 {

    static String S1, S2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S1 = br.readLine();
        S2 = br.readLine();

        dp = new int[S1.length() + 1][S2.length() + 1];

        for(int i=1; i<=S1.length(); i++) {
            for(int j=1; j<=S2.length(); j++) {
                if(S1.charAt(i-1) == S2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[S1.length()][S2.length()]);

        br.close();
    }
}
