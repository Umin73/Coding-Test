package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 {
    static int N;
    static int[] arr;
    static int answer = 0;

    static void solution(int depth) {
        if(depth == N) {
            answer++;
            return;
        }

        for(int i=0; i<N; i++) {
            arr[depth] = i;
            if(isPossible(depth)) solution(depth+1);
        }
    }

    static boolean isPossible(int col) {
        for(int i=0; i<col; i++) {
            if(arr[i] == arr[col]) return false;
            if(Math.abs(col - i) == Math.abs(arr[col]-arr[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        /*
        * 퀸은 가로, 세로, 대각선으로 움직일 수 있음
        * -> 현재 퀸의 위치에서 같은 행, 열, 대각선에 다른 퀸 존재할 수 X
        * */
        solution(0);
        System.out.println(answer);
        br.close();
    }
}
