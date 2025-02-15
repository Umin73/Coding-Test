package 백준;

import java.io.*;
import java.util.*;

public class _2644 {
   static int N, M;
   static int p1, p2;
   static boolean[][] graph;
   static boolean[] visited;
   static int answer = -1;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st;

      N = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      p1 = Integer.parseInt(st.nextToken());
      p2 = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(br.readLine());

      graph = new boolean[N+1][N+1];
      visited = new boolean[N+1];

      int x, y;
      for (int i=0; i<M; i++) {
         st = new StringTokenizer(br.readLine());
         x = Integer.parseInt(st.nextToken());
         y = Integer.parseInt(st.nextToken());

         graph[x][y] = true;
         graph[y][x] = true;
      }

      dfs(p1, 0);

      bw.write(String.valueOf(answer));
      bw.flush();

      bw.close();
      br.close();
   }

   static void dfs(int idx, int cnt) {
      visited[idx] = true;

      if(idx == p2) {
         answer = cnt;
         return;
      }

      for(int i=1;i<=N;i++) {
         if(!visited[i] && graph[idx][i]) {
            dfs(i, cnt+1);
         }
      }
   }
}
