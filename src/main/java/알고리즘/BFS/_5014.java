package 알고리즘.BFS;

import java.io.*;
import java.util.*;

public class _5014 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int F = Integer.parseInt(input[0]); // 건물의 총 층수 F
        int S = Integer.parseInt(input[1]); // 현재 층수 S
        int G = Integer.parseInt(input[2]); // 목표 층수 G
        int U = Integer.parseInt(input[3]); // U만큼 위로 올라감
        int D = Integer.parseInt(input[4]) * -1; // D만큼 아래로 내려감

        if(S == G) {
            System.out.println(0);
            br.close();
            return;
        }

        int[] arr = new int[F+1];
        boolean[] visited = new boolean[F+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;

        int[] move = {U, D};
        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(cur == G) {
                break;
            }

            for(int i =0; i<move.length; i++) {
                int next = cur + move[i];

                if(next >= 1 && next <= F && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    arr[next] = arr[cur] + 1;
                }
            }
        }
        System.out.println(arr[G] != 0 ? arr[G] : "use the stairs");
        br.close();
    }
}
