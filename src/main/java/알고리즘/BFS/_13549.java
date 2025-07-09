package 알고리즘.BFS;

import java.io.*;
import java.util.*;

public class _13549 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 수빈이의 위치
        int K = Integer.parseInt(input[1]); // 동생의 위치

        int[] arr = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == K) {
                break;
            }

            int next = cur * 2;
            if(next >=0&& next<=100000 && !visited[next]) {
                queue.offer(next);
                visited[next] = true;
                arr[next] = arr[cur];
            }

            next = cur - 1;
            if(next >=0&& next<=100000 && !visited[next]) {
                queue.offer(next);
                visited[next] = true;
                arr[next] = arr[cur] + 1;
            }

            next = cur + 1;
            if(next >=0&& next<=100000 && !visited[next]) {
                queue.offer(next);
                visited[next] = true;
                arr[next] = arr[cur] + 1;
            }
        }

        System.out.println(arr[K]);
        br.close();
    }
}
