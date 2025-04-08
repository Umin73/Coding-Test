package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11053 {
    static int N;
    static int[] A;
    static int answer = 1;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        memo = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i < N; i++) {
            memo[i] = 1;
            for(int j=0; j<= i-1; j++) {
                if(A[j] < A[i]) {
                    memo[i] = Math.max(memo[i], memo[j]+1);
                }
            }
            answer = Math.max(answer, memo[i]);
        }
        System.out.println(answer);

        br.close();
    }
}
