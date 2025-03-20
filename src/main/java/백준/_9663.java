package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 {
    static int N;
    static int answer = 0;
    static int[] arr;
    static int solution(int depth) {
        // depth라고 썼지만, 간단하게 depth번째 퀸이라 생각하면 됨
        if(depth == N) {
            answer++;
            return depth;
        }

        for(int i=0; i < N; i++) {
            arr[depth] = i; // depth번째 퀸을 i열에 위치시킴
            if(possible(depth)) { // i열에 위치시킨 depth번째 퀸이 이 위치에 놓아도 되는지
                solution(depth+1); // 다음 순서의 퀸의 위치를 정하러 감
            }
        }
        return depth;
    }

    static boolean possible(int col) {
        for(int i=0; i< col; i++) { // 이전에 놓였던 퀸들을 확인

            // 같은 열에 퀸이 있는 경우
            if(arr[i] == arr[col]) return false;
            // 대각선에 퀸이 있는 경우
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true; // 현재 퀸이 다른 퀸들과 서로 공격할 수 없는 위치에 있으면 true
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        /*
        * N*N 체스판이면 2차원 배열 써야 할 것 같은데 왜 1차원 배열을 썼나?
        * -> 한 행 or 한 열에 하나의 퀸밖에 오지 못함
        *    같은 줄에 있으면 공격 가능해짐
        * */

        solution(0);
        System.out.println(answer);
        br.close();
    }
}
