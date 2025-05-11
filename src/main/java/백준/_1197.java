package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class _1197 {

    static int V, E;
    static List<Node> nodeList;
    static int[] parentArr;

    static class Node implements Comparable<Node> {
        int v1, v2, weight;

        Node(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]); // 정점의 개수
        E = Integer.parseInt(input[1]); // 간선의 개수

        nodeList = new ArrayList<>();
        parentArr = new int[V + 1];

        for(int i=0; i<E; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);

            nodeList.add(new Node(x,y,z));
        }

        Collections.sort(nodeList);

        for(int i=1; i<=V; i++) {
            parentArr[i] = i;
        }


        br.close();
    }
}
