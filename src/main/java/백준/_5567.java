package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _5567 {

    static int N, M;
    static ArrayList<Integer> queue;
    static ArrayList<Integer> friends;
    static boolean[][] graph;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        int x, y;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        bfs();

        bw.write(String.valueOf(answer));
        bw.flush();

        bw.close();
        br.close();
    }
//
//    static void dfs(int idx, int cnt) {
//        visited[idx] = true;
//        if(cnt > 2) return;
//        if(idx != 1) answer++;
//
//        for(int i=1;i<=N;i++) {
//            if(!visited[i] && graph[idx][i]) {
//                dfs(i, cnt+1);
//            }
//        }
//    }

    static void bfs() {
        queue = new ArrayList<>();
        friends = new ArrayList<>();

        queue.add(1);
        friends.add(1);
        visited[1] = true;

        while (!friends.isEmpty()) {
            int idx = queue.remove(0);
            friends.remove(0);
            for(int i=1;i<=N;i++) {
                if(!visited[i] && graph[idx][i]) {
                    if(idx == 1) {
                        friends.add(i);
                    }
                    visited[i] = true;
                    queue.add(i);
                    answer++;
                }
            }
        }
    }
}
