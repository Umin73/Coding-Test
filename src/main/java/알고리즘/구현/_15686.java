package 알고리즘.구현;

import java.io.*;
import java.util.*;

public class _15686 {

    static int N, M;
    static int[][] map;
    static boolean[] selected;
    static List<int[]> chickenList = new ArrayList<>();
    static List<int[]> homeList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    static int calculateChickenDist() {
        int total = 0;

        for(int i=0; i<homeList.size(); i++) {
            int[] curHome = homeList.get(i);
            int minDist = Integer.MAX_VALUE;

            for(int j=0; j<chickenList.size(); j++) {
                if(!selected[j]) continue;
                int[] curChicken = chickenList.get(j);
                int dist = Math.abs(curHome[0] - curChicken[0]) + Math.abs(curHome[1] - curChicken[1]);
                minDist = Math.min(minDist, dist);
            }
            total += minDist;
        }
        return total;
    }

    static void dfs(int start, int depth) {
        if(depth == M) {
            answer = Math.min(answer, calculateChickenDist());
            return;
        }

        for(int i=start; i<chickenList.size(); i++) {
            selected[i] = true;
            dfs(i+1, depth+1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]); // 폐업시키지 않을 치킨집 수

        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            input = br.readLine().split(" ");
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
                if(map[i][j] == 1) homeList.add(new int[]{i, j});
                if(map[i][j] == 2) chickenList.add(new int[]{i, j});
            }
        }
        selected = new boolean[chickenList.size()];
        dfs(0,0);

        System.out.println(answer);

        br.close();
    }
}
