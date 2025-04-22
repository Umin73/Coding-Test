package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _4485 {

    static int N;
    static int[][] arr;
    static int[][] minCostArr;

    static StringBuilder sb = new StringBuilder();
    static int tc = 1;

    // Comparable은 정렬 기준을 정해주는 인터페이스
    // Comparable<Node>는 Node 클래스는 다른 Node 객체와 비교할 수 있다고 선언하는것
    static class Node implements Comparable<Node> {

        int x, y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 음수면, this가 더 작고(우선순위 높음), 양수면 this가 더 큰 거(우선순위 낮음)
        }
    }

    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
    static void solution() {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        // PriorityQueue는 자바에서 제공하는 Comparable 인터페이스 이용해서 객체 정렬 순서를 정함
        // 그래서 Node 클래스를 Comparable 인터페이스로 구현하면
        // PriorityQueue는 Node의 정렬 기준(이 코드에선, cost 기준)을 따르게 됨

        // 시작 지점의 비용을 초기화하고 큐에 삽입
        minCostArr[0][0] = arr[0][0];
        pq.offer(new Node(0,0,arr[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.x == N-1 && cur.y == N-1){
                sb.append("Problem ").append(tc++).append(": ").append(cur.cost).append("\n");
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if(nextX >=0 && nextX < N && nextY>=0 && nextY < N) {
                    int tempCost = arr[nextX][nextY] + minCostArr[cur.x][cur.y];
                    if(tempCost < minCostArr[nextX][nextY]) { // 더 적은 비용으로 도달할 수 있으면 비용 갱신하고 큐에 추가
                        minCostArr[nextX][nextY] = tempCost;
                        pq.offer(new Node(nextX, nextY, tempCost));
                        // 같은 좌표에 해당하는 Node 객체가 우선순위 큐에 여러 번 들어갈 수 있음
                        // But, 다익스트라 알고리즘은 가장 먼저 도달한 경로가 항상 최적의 경로X
                        // So, 우선순위 큐를 통해 더 짧은 비용을 도달할 수 있다면 다시 방문
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        while(N != 0) {
            arr = new int[N][N];
            minCostArr = new int[N][N];

            for(int i=0; i<N; i++) {
                String[] input = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                    minCostArr[i][j] = Integer.MAX_VALUE;
                }
            }
            solution();

            N = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
        br.close();
    }
}
