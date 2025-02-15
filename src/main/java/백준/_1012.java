package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class _1012 {
    final static int MAX = 50 + 10;
    static int T, M, N, K;
    static boolean[][] map;
//    static boolean[][] visited;
    static int answer = 0;

    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX];
//            visited = new boolean[MAX][MAX];

            int x, y;
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[y+1][x+1] = true;
            }

            for(int i=1;i<=N; i++) {
                for(int j=1;j<=M;j++) {
                    if(map[i][j]) {
                        dfs(i,j);
                        answer++;
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();

            answer = 0;
        }

        bw.close();
        br.close();
    }

    static void dfs(int y, int x) {
//        visited[y][x] = true;
        map[y][x] = false;

        for(int i=0; i<4;i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
//            if(map[newY][newX] && !visited[newY][newX])
//                dfs(newY,newX);
            if(map[newY][newX])
                dfs(newY,newX);
        }
    }
}
