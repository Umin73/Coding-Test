package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11725 {

    final static int MAX = 100001;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[MAX];
        visited = new boolean[MAX];
        answer = new int[MAX];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int x,y;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        for(int i=2; i<=N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }
        bw.flush();

        bw.close();
        br.close();


    }

    static void dfs(int idx) {
        visited[idx] = true;

        for(int i = 0; i<graph[idx].size(); i++) {
            int next = graph[idx].get(i);

            if(!visited[next]) {
                answer[next] = idx; // 다음에 방문할 노드의 부모는 현재 노드
                dfs(next);
            }
        }
    }
}
