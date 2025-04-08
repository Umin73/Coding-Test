package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12865 {
    static int N, K;
    static int[][] wv;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // N: 물품의 수
        K = Integer.parseInt(input[1]); // K: 준서가 버틸 수 있는 무게

        dp = new int[K+1];
        wv = new int[N][2];
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            wv[i][0] = Integer.parseInt(input[0]);
            wv[i][1]= Integer.parseInt(input[1]);
        }

        for(int i=0; i<N; i++) {
            int weight = wv[i][0];
            int value = wv[i][1];

            // 해당 물건을 배낭에 넣을지 말지 결정
            for(int j = K; j>= weight; j--) { // 현재 물건의 영향이 다음 계산이 미치지 않도록 거꾸로 반복문 돌림
                // dp[j-weight]: 이전 상태까지의 최대 가치
                dp[j] = Math.max(dp[j], dp[j-weight] + value);
            }
        }

        System.out.println(dp[K]);
        br.close();
    }
}
