package 알고리즘.Bruteforcing;

import java.io.*;

public class _9663 {

    static int N;
    static int[] board;
    static int answer = 0;

    static boolean possibleCheck(int pos) {
        for(int i=0; i<pos; i++) {
            // 같은 줄에 있으면 false
            if(board[i] == board[pos]) return false;

            // 같은 대각선 라인에 있으면 false
            if(Math.abs(pos - i) == Math.abs(board[pos] - board[i])) return false;
        }

        return true;
    }

    static void solution(int depth) {
        if(depth == N) {
            answer++;
            return;
        }

        for(int i=0; i<N; i++) {
            board[depth] = i;
            if(possibleCheck(depth)) solution(depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N];

        solution(0);

        System.out.println(answer);

        br.close();
    }
}
