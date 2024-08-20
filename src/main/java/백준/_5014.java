package 백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _5014 {

    static ArrayList<ArrayList<Integer>> list
            = new ArrayList<ArrayList<Integer>>();
    static boolean[] check = new boolean[1000001];
    static int[] cost = new int[1000001];
    static int F, S, G, U, D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();   // 건물의 총 층수
        S = sc.nextInt();   // 현재 층수
        G = sc.nextInt();   // 스타트링크가 있는 층수
        U = sc.nextInt();   // 위로 U층을 올라가는 버튼
        D = sc.nextInt();   // 아래로 D층을 내려가는 버튼

        for (int i = 0; i <= F; i++) {
            list.add(new ArrayList<Integer>());
            list.get(i).add(i+U);
            list.get(i).add(i-D);
            check[i] = false;
            cost[i] = 0;
        }

        int answer = bfs();
        System.out.println((answer != -1 ? answer : "use the stairs"));
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(S);
        check[S] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if(cur == G) {
                return cost[cur];
            }

            int next = list.get(cur).get(0);
            if(next <= F && !check[next]) {
                q.offer(next);
                check[next] = true;
                cost[next] = cost[cur] + 1;
            }
            next = list.get(cur).get(1);
            if(next >= 1 && !check[next]) {
                q.offer(next);
                check[next] = true;
                cost[next] = cost[cur] + 1;
            }
        }
        return -1;
    }
}
