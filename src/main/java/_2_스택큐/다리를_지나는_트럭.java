package _2_스택큐;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

    public static void main(String[] args) {

        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

    // bridge_length : 다리에 최대로 올라갈 수 있는 트럭의 수 (즉, 트럭이 다리를 건너는 데 걸리는 시간)
    // weight : 다리가 견딜 수 있는 최대 무게
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();  // bridge_length 만큼의 크기를 갖는 큐 생성

        for(int i=0;i<bridge_length;i++) {
            bridge.offer(0); // queue에 bridge_length만큼의 값들을 넣고 모두 0으로 초기화
        }

        if(bridge_length == 1) return truck_weights.length + 1; // 다리의 길이가 1인 경우
        if(truck_weights.length == 1) return bridge_length + 1; // 트럭이 1개인 경우

        int idx = 0;
        int totalWeight = 0;
        while(idx < truck_weights.length) {
            totalWeight -= bridge.poll();
            answer++;

            if(totalWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx++];
            } else {
                bridge.offer(0);
            }
        }
        answer += bridge_length;    // 마지막으로 다리에 오른 트럭이 다리를 다 건너기까지 걸리는 시간을 더하기

        return answer;
    }
}
