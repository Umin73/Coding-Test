package 알고리즘.BFS;

import java.io.*;
import java.util.*;

public class _1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 수빈이의 현재 위치
        int K = Integer.parseInt(input[1]); // 동생의 현재 위치
        int[] arr = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;
        arr[N] = 0;

        int[] move = new int[]{-1, 1, 2};
        while(!queue.isEmpty()) {
            int curPos = queue.poll();

            if(curPos == K) {
                break;
            }

            for(int i=0; i<3; i++) {
                int nextPos = (move[i] == 2) ? curPos * 2 : curPos + move[i];

                if(nextPos >= 0 && nextPos <= 100000 && !visited[nextPos]) {
                    queue.offer(nextPos);
                    visited[nextPos] = true;
                    arr[nextPos] = arr[curPos] + 1;
                }
            }
        }
        System.out.println(arr[K]);
        br.close();
    }
}
