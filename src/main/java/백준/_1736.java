package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class _1736 {
    static int N, M;
    static int[][] arr;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int robotX, robotY;
        int nextRight = 0;
        int nextBottom = 0;
        while (!isClean()) {
            robotX = 0;
            robotY = 0;

            while(!(robotX == N-1 && robotY == M-1)) {
                nextRight = existsOnRight(robotX, robotY);
                nextBottom = existsOnBottom(robotX, robotY);

                if(nextRight == 101 && nextBottom == 101) {
                    if(robotX == M-1) break;

                    if(robotX < M-1) robotX++;
                    else if(robotY < N-1) robotY++;
                } else {
                    if(nextRight < nextBottom) robotX = nextRight;
                    else if(nextBottom < nextRight) robotY = nextBottom;
                    else if(robotY == N-1) robotX++;
                    else if(robotX == M-1) robotY++;

                }
                arr[robotY][robotX] = 0;
            }

            answer++;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    static boolean isClean() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 1)  return false;
            }
        }
        return true;
    }

    static int existsOnRight(int curX, int curY) {
        for(int i=curX+1; i<M; i++) {
            if(arr[curY][i] == 1) return i; // 오른쪽 쓰레기의 X좌표를 리턴
        }
        return 101;
    }

    static int existsOnBottom(int curX, int curY) {
        for(int i=curY+1; i<N; i++) {
            if(arr[i][curX] == 1) return i; // 아래쪽 쓰레기의 Y좌표를 리턴
        }
        return 101;
    }
}
