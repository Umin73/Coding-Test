package 백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _18352 {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static int[] distance = new int[300001];
    static int N, M, K, X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 도시의 개수
        M = sc.nextInt();   // 도로의 개수
        K = sc.nextInt();   // 거리 정보
        X = sc.nextInt();   // 출발 도시

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Integer>());
            distance[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            list.get(A).add(B);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(X);
        distance[X] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < list.get(cur).size(); i++) {
                int next = list.get(cur).get(i);
                if(distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if(distance[i] == K) {
                System.out.println(i);
                flag = true;
            }
        }

        if(!flag) {
            System.out.println(-1);
        }
    }

}
