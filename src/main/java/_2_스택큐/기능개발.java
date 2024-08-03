package _2_스택큐;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

    static public Object[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<>();

        int progressIdx = 0;
        Queue<Integer> queue = new LinkedList<>();

        while(progressIdx < progresses.length) {
            for(int i = progressIdx; i < progresses.length;i++) {
                if(progresses[i] >= 0 && progresses[i] < 100) { // 개발 미완
                   progresses[i] += speeds[i];
                }
                if(progresses[i] >= 100) {
                    progresses[i] = -1;
                }
            }

            int k = progressIdx;
            while(progresses[k] == -1) {
                if(progresses[k] == -1) {
                    queue.offer(k++);
                }
                if(k >= progresses.length) break;
            }

            if(progresses[progressIdx] == -1) {
                int j;
                for(j = progressIdx; j < progresses.length; j++) {
                    if(progresses[j] >= 0 && progresses[j] < 100) {
                        progressIdx = j;
                        break;
                    }
                }
                if(j == progresses.length) {
                    progressIdx = progresses.length;
                }

                answer.add(queue.size());
                queue.clear();
            }
        }

        return answer.toArray();
    }
}
