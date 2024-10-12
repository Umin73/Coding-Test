package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class _2606 {

    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

   public static void main(String[] args) throws IOException {

       // 0. 입력 및 초기화
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       N = Integer.parseInt(br.readLine());
       M = Integer.parseInt(br.readLine());

       graph = new boolean[N+1][N+1];
       visited = new boolean[N+1];

       // 1. graph에 연결 정보 채우기
       int x, y;
       for (int i = 0; i < M; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           x = Integer.parseInt(st.nextToken());
           y = Integer.parseInt(st.nextToken());
           graph[x][y] = true;
           graph[y][x] = true;
       }

       // 2. dfs(재귀함수) 호출
       dfs(1);

       // 3. 출력
       bw.write(String.valueOf(answer - 1));

       br.close();
       bw.close();
   }

    private static void dfs(int idx) {
         visited[idx] = true;
         answer++;

         for(int i = 1; i <= N; i++) {
             if(!visited[i] && graph[idx][i]) dfs(i);
         }
    }

}
