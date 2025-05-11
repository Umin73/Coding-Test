package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3151 {

    static int N;
    static int[] arr;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
        for(int i=0; i<N-2; i++) { // 첫번째 원소 i 고정
            int p1 = i+1; // 두 번째 포인터(i보다 오른쪽에서 시작)
            int p2 = N-1; // 세 번째 포인터(맨 끝에서 시작)

            while (p1 < p2) {
                int tempSum = arr[p1] + arr[p2] + arr[i];

                // 합이 0인 경우: 조합 조건 만족
                if(tempSum == 0) {
                    if(arr[p1] == arr[p2]) { // arr[p1]부터 arr[p2]까지 전부 같은 값
                        int count = p2 - p1 + 1;// 중간에 있는 동일한 값의 개수

                        // 같은 값 중 2개를 고르는 조합의 수 nC2
                        answer += count * (count - 1) /2;
                        break;
                    } else {
                        // arr[p1]과 arr[p2]가 서로 다를 때
                        int leftCount = 1; // arr[p1]의 중복 개수
                        int rightCount = 1; // arr[p2]의 중복 개수

                        // arr[p1]의 중복 개수 세기
                        while(p1+1 < p2 && arr[p1] == arr[p1+1]) {
                            leftCount++;
                            p1++;
                        }

                        // arr[p2]의 중복 개수 세기
                        while(p2-1 > p1 && arr[p2] == arr[p2-1]) {
                            rightCount++;
                            p2--;
                        }

                        answer += leftCount * rightCount;

                        // 중복 구간 지나고 다음 값으로 이동
                        p1++;
                        p2--;
                    }
                } else if(tempSum > 0) p2--;
                else p1++;
            }
        }
        System.out.println(answer);

        br.close();
    }
}
