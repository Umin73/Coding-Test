package 문과생도_이해하는_DFS_알고리즘;

import java.io.*;

public class _13565 {

    static int M, N; // M: 세로
    static int[][] arr;
    static int[][] dirs = {{0, 1}, {0, -1}, {1,0}, {-1, 0}};

    static boolean isYes() {
        for (int i = 0; i < N; i++) {
            if(arr[M-1][i] == 2) return true;
        }
        return false;
    }

    static void dfs(int curY, int curX) {
        if(arr[curY][curX] != 0) return; // true이면 return

        arr[curY][curX] = 2;
        for(int i=0; i<4; i++) {
            int nextY = curY + dirs[i][0];
            int nextX = curX + dirs[i][1];

            if(nextY >= 0 && nextY < M && nextX >=0 && nextX < N) {
                dfs(nextY, nextX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        arr = new int[M][N];

        for (int i = 0; i < M; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<N; i++) {
            if(arr[0][i] == 0) dfs(0,i);
        }

        System.out.println(isYes() ? "YES" : "NO");

        br.close();
    }
}
