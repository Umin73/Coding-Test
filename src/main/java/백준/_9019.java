package 백준;

import java.io.*;
import java.util.ArrayDeque;

public class _9019 {
    static int T, A, B;
    static int MAX = 9999;
    static ArrayDeque<Integer> queue; // Queue 인터페이스 구현한게 아니고, 내부가 배열 기반이라 더 빠름.
    // queue.poll(), queue.offer()도 상수시간 O(1)만큼 걸림

    static boolean[] visited;
//    static String[] candidate;
// String[]은 문자열을 계속 + 연산으로 만들어서 매번 새 문자열 생성 -> 가비지컬렉터 부담 -> 느려짐
    static int[] parent; // 다음 노드의 이전 노드 저장
    static char[] chars; // 현재 노드까지 어떤 명령어들로 왔는지 저장

    static void printCommands() {
        StringBuilder sb = new StringBuilder();
        int c = B;
        // B에서 거꾸로 A까지 parent 배열을 따라가면서 이 숫자를 누가 만들었는지 추적
        while(c != A) {
            // chars[1234] = 'D'라면 617->1234로 가는데 'D'를 사용
            // parent[1234] = 617
            // 현재숫자가 1234라면, 그 전 숫자 617에서 'D'를 통해 1234로 왔다
            sb.append(chars[c]); // 명령어 누적
            c = parent[c]; // 현재 숫자 c를 만들었던 부모로 이동
        }
        System.out.println(sb.reverse());
    }

    static void BFS() {
        visited = new boolean[MAX+1];
        parent = new int[MAX+1];
        chars = new char[MAX+1];
        queue = new ArrayDeque<>();

        visited[A] = true;
        queue.offer(A);

        while(!queue.isEmpty()) {
            int curNum = queue.poll();

            int D = (2*curNum) % (MAX+1);
            int S = curNum == 0 ? MAX : curNum - 1;
            int L = (curNum%1000) * 10 + (curNum/1000);
            int R = (curNum%10)*1000 + (curNum / 10);

            int[] commands = {D, S, L, R};
            char[] commandChars = {'D', 'S', 'L','R'};
            for (int i=0; i<4; i++) {
                int nextNum = commands[i];
                if(!visited[nextNum]) {
                    visited[nextNum] = true;
                    parent[nextNum] = curNum;
                    chars[nextNum] = commandChars[i];
                    if(nextNum == B) {
                        printCommands();
                        return;
                    }
                    queue.offer(nextNum);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String[] input = br.readLine().split(" ");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);

            BFS();
        }
    }
}
