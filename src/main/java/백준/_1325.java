package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1325 {
    final static int MAX = 10001;
    static int N, M;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[MAX];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int x, y;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[y].add(x);
        }

        int maxCnt = -1;
        StringBuilder answer = new StringBuilder();
        for(int i=1;i<=N;i++) {
            if(graph[i].size() > maxCnt) {
                maxCnt = graph[i].size();
                answer = new StringBuilder();
                for(int j=0;j<graph[i].size();j++) {
                    answer.append(graph[i].get(j)).append(" ");
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }
}
