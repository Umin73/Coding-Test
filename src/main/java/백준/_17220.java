package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17220 {

    static int N, M;
    static int answer = 0;
    static int drugDealerCnt;
    static Map<Character, List<Character>> graph = new HashMap<>(); // 인접 리스트(노드 간 관계 저장)
    static Map<Character, Integer> degree = new HashMap<>(); // 각 노드가 부모로부터 얼마나 연결되었는지(부모 노드 개수, 부모노드가 0인(루트)부터 시작해야하니)
    static Set<Character> visited = new HashSet<>(); // 이미 체포된 마약범 체크
    // 왜 boolean[] 대신 Set<Character>로 했는지??
    // 입력이 int형이 아닌 char형이라 visited['A'-'A'+1] 이렇게 하면 가독성 불편해짐
    // Set<Character>를 쓰면 그냥 깔끔하게 바로 'B'를 넣고 찾을 수 있어짐
    // 그리고 boolean쓰면 무조건 26칸으로 배열 만들어야하는데
    // Set은 그런거 신경 안써도 됨


    static void solution(char curNode) {
        if(visited.contains(curNode)) return; // 이미 체포(?)된 마약범이면 탐색X

        if(graph.get(curNode) != null) {
            for (char nextNode : graph.get(curNode)) {
                if(!visited.contains(nextNode)) {
                    answer++; // 아직 체포X인 것 발견할 때마다 answer++
                    solution(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i = 0;i<M; i++) {
            input = br.readLine().split(" ");
            char parent = input[0].charAt(0);
            char child = input[1].charAt(0);

            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(child); // 자식 등록 (누가 누구에가 마약 공급했는지)

            degree.put(child, degree.getOrDefault(child, 0) + 1);
            degree.put(parent, degree.getOrDefault(parent, 0));
        }

        input = br.readLine().split(" ");
        drugDealerCnt = Integer.parseInt(input[0]);
        for (int i=0; i<drugDealerCnt; i++) {
            char dealer = input[1+i].charAt(0);
            visited.add(dealer); // 이미 알려진 마약범들은 미리 visited=true
        }

        for(char node: degree.keySet()) {
            if(degree.get(node) == 0) {
                solution(node);
            }
        }

        System.out.println(answer);

        br.close();
    }
}
