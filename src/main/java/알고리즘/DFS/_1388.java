package 알고리즘.DFS;

import java.io.*;
public class _1388 {

    static int N, M; // N: 세로, M: 가로
    static char[][] arr;
    static int[] dirs = {-1, 1};

    static void dfsA(int curY, int curX) {
        if(arr[curY][curX] != '-') return;

        arr[curY][curX] = ' ';
        for(int i=0; i<2; i++) {
            int nextX = curX + dirs[i];
            if(nextX >= 0 && nextX < M) dfsA(curY, nextX);
        }
    }

    static void dfsB(int curY, int curX) {
        if(arr[curY][curX] != '|') return;

        arr[curY][curX] = ' ';
        for(int i=0; i<2; i++) {
            int nextY = curY + dirs[i];
            if(nextY >= 0 && nextY < N) dfsB(nextY, curX);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split("");
            for(int j=0; j<M; j++)  {
                arr[i][j] = input[j].charAt(0);
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == '-') {
                    dfsA(i, j);
                    answer++;
                }
                else if(arr[i][j] == '|') {
                    dfsB(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}
