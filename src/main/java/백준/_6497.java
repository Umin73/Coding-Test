package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _6497 {

    static int M, N;
    static ArrayList<Node> nodeList;
    static int[] parentArr;
    static int[] rankArr; // 깊이 저장용

    static class Node implements Comparable<Node> {
        int home1;
        int home2;
        int distance;

        public Node(int home1, int home2, int distance) {
            this.home1 = home1;
            this.home2 = home2;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static int find(int v) {
        if(parentArr[v] == v) return v;
        else return parentArr[v] = find(parentArr[v]);
    }

    static boolean union(int from, int to) {
        int fromRoot = find(from); // from 노드가 속한 집합의 대표(루트) 노드 찾기
        int toRoot = find(to); // to 노드가 속한 집합의 대표(루트) 노드 찾기

        if(fromRoot == toRoot) return false; // 이미 같은 집합 -> union 하지X (사이클 방지)

        // 두 루트가 서로 다른 집합일 때 어떤식으로 합칠지 결정
        // 트리 깊이를 고려한 union : 깊이가 더 낮은 트리를 깊이가 높은 트리쪽에 붙임 -> 트리 길이 증가X
        if(rankArr[fromRoot] < rankArr[toRoot]) {
            parentArr[fromRoot] = toRoot; // 작은 쪽의 부모 노드를 큰 쪽의 노드로 변경 -> 트리 연결됨
        } else if(rankArr[fromRoot] > rankArr[toRoot]) {
            parentArr[toRoot] = fromRoot;
        } else { // 두 트리의 깊이가 같은 경우
            parentArr[toRoot] = fromRoot;
            rankArr[fromRoot]++;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);

            if (M == 0 && N== 0) break;

            int totalCost = 0;
            int cost = 0;
            parentArr = new int[M];
            rankArr = new int[M];
            nodeList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int z = Integer.parseInt(input[2]);

                nodeList.add(new Node(x, y, z));
                totalCost += z;
            }

            Collections.sort(nodeList);

            for (int i = 0; i < M; i++) {
                parentArr[i] = i;
                rankArr[i] = 0;
            }

            int cnt = 0;
            for (Node node : nodeList) {
                if (union(node.home1, node.home2)) {
                    cost += node.distance;
                    cnt++;
                    if (cnt == M - 1) break;
                }
            }

            sb.append(totalCost - cost).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
