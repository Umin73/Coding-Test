package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1535 {
    static int N;
    static int[] L, J;
    static int Life = 100;
    static int Joy = 0;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = new int[N];
        J = new int[N];
        dp = new int[100]; // dp[i] = 체력이 i일 때의 최대 기쁨

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            L[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            J[i] = Integer.parseInt(input[i]);
        }

        for(int i=0; i<N; i++) {
            for(int j=99; j>=L[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-L[i]]+J[i]);
            }
        }
        System.out.println(dp[99]);
        br.close();
    }
}
