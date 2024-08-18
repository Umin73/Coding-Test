package 프로그래머스._5_완전탐색;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 전력망을_둘로_나누기 {

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
        System.out.println(solution(4, new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
    }

    private static List<List<Integer>> list;
    private static boolean[] visited;
    private static int answer;

    public static int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            bfs(i, n, wires);
        }

        return answer;
    }

    private static void bfs(int idx, int n, int[][] wires) {

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            if(i == idx) continue;  // 이 부분의 송전탑들의 연결 끊기
            int a = wires[i][0];
            int b = wires[i][1];

            list.get(a - 1).add(b - 1); //(a-1)에 (b-1)송전탑이 연결됨
            list.get(b - 1).add(a - 1); //(b-1)에 (a-1)송전탑이 연결됨
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);

        visited = new boolean[n];
        visited[0] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int o:list.get(cur)) {
                if(!visited[o]) {
                    visited[o] = true;
                    q.offer(o);
                }
            }
        }

        int towerA = 0;
        int towerB = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) towerA++;
            else towerB++;
        }

        answer = Math.min(answer, Math.abs(towerA-towerB));
    }
}
