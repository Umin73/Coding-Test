package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1260 {

    final static int MAX = 1001;
    static boolean[][] graph;
    static boolean[] visited;
    static ArrayList<Integer> queue;
    static int N,M,V;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        int x, y;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(V);
        System.out.println();

        bfs();
    }

    static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx + " ");

        for(int i=1; i<=N; i++) {
            if(!visited[i] && graph[idx][i]) {
                dfs(i);
            }
        }
    }

    static void bfs() {
        queue = new ArrayList<>();
        visited = new boolean[MAX];

        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()) {
            int idx = queue.remove(0);
            System.out.print(idx + " ");
            for(int i=1; i<=N; i++) {
                if(!visited[i] && graph[idx][i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}
