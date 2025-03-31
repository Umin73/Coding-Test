package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15961 {
    static int N, D, K, C;
    static int[] sushiArr; // 초밥 벨트
    static int[] sushiCntArr; // 각 초밥의 개수 저장
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 회전 초밥 벨트에 놓인 접시 수
        D = Integer.parseInt(input[1]); // 초밥의 가짓수
        K = Integer.parseInt(input[2]); // 연속해서 먹는 접시의 수
        C = Integer.parseInt(input[3]); // 쿠폰 번호

        sushiArr = new int[N*2];
        sushiCntArr = new int[D+1];
        for (int i = 0; i < N; i++) {
            sushiArr[i] = Integer.parseInt(br.readLine());
            sushiArr[N+i] = sushiArr[i];
        }
        int variety = 0;

        // 초기 초밥들 설정
        for(int i=0; i<K; i++) {
            sushiCntArr[sushiArr[i]]++;
            if(sushiCntArr[sushiArr[i]] == 1) variety++;
        }

        int tempAnswer = variety;
        if(sushiCntArr[C] == 0) tempAnswer++;
        answer = tempAnswer;

        for(int i=1; i<N; i++) {
            int removeIdx = sushiArr[i-1];
            int addIdx = sushiArr[K+i-1];

           sushiCntArr[removeIdx]--;
            if(sushiCntArr[removeIdx] == 0) variety--;

            sushiCntArr[addIdx]++;
            if(sushiCntArr[addIdx] == 1) variety++;

            // 쿠폰 고려해서 최대 종류값 구하기
            tempAnswer = variety;
            if(sushiCntArr[C] == 0) tempAnswer++;
            answer = Math.max(answer, tempAnswer);
        }

        System.out.println(answer);
        br.close();
    }
}
