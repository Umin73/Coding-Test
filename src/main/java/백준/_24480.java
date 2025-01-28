package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _24480 {
    static int MAX = 100001;
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean []visited;
    static int []answer;
    static int order = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[MAX];
        visited = new boolean[MAX];
        answer = new int[MAX];

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int u,v;
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        dfs(R);

        for(int i = 1; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx) {
        if(visited[idx]) return;
        else {
            visited[idx] = true;
            answer[idx] = order++;

            for(int i = 0; i < graph[idx].size(); i++) {
                int next = graph[idx].get(i);
                if(!visited[next]) dfs(next);
            }
        }
    }
}
