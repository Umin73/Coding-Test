package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class _11724 {

    final static int MAX = 1001;
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. graph에 연결 정보 채우기
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u][v] = true;
            graph[v][u] = true;
        }

        // 2. dfs(재귀함수 호출)
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        // 3. 출력
        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 1; i <= N; i++) {
            if(graph[idx][i] && !visited[i]) dfs(i);
        }
    }
}
