package 프로그래머스._힙;

import java.io.*;
import java.util.*;

public class _디스크컨트롤러 {

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int time = 0;
        int idx = 0;
        int done = 0;
        int total = 0;

        while(done < jobs.length) {
            // 현재 시각까지 도착한 작업을 모두 PQ에 넣기
            while(idx < jobs.length  && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }

            // 바로 처리할 작업 없으면 다음 도착 시간으로 점프
            if(pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }

            int[] cur = pq.poll(); // 가장 짧은 작업 수행
            time += cur[1];
            total += time - cur[0]; // 요청 ~ 완료 시간 누적
            done++;
        }

        return total / jobs.length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().replace("[","")
                                    .replace("]","")
                                    .replace(" ","")
                                    .split(",");

        int[][] jobs = new int[input.length / 2][2];
        for(int i=0; i<input.length/2; i++) {
            jobs[i][0] = Integer.parseInt(input[i*2]);
            jobs[i][1] = Integer.parseInt(input[(i*2)+1]);
        }

        System.out.println(solution(jobs));

        br.close();
    }
}
