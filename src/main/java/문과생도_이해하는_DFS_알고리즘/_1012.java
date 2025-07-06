package 문과생도_이해하는_DFS_알고리즘;

import java.io.*;

public class _1012 {

    static int T;
    static int M, N, K; // M: 가로, N: 세로
    static boolean[][] arr;
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    static public void dfs(int curX, int curY) {
        if(!arr[curY][curX]) return;

        arr[curY][curX] = false;
        for(int i=0; i<4; i++) {
            int nextX = curX + dirs[i][0];
            int nextY = curY + dirs[i][1];

            if(nextX >= 0 && nextX < M && nextY >=0 && nextY < N) {
                dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            arr = new boolean[N][M];

            while(K-- > 0) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);

                arr[y][x] = true;
            }

            int answer = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j]) {
                        dfs(j,i);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }


        br.close();
    }
}
