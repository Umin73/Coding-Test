package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class _2606 {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N][N];
        visited = new boolean[N];

        int x, y;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(0);

        bw.write(4);

        br.close();
        bw.close();
    }

    static void dfs(int idx) {
        visited[idx] = true;

        for(int i=0; i<N; i++) {
            if(graph[idx][i] && !visited[i]) dfs(i);
        }

        answer++;
    }
}
