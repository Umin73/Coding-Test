package 프로그래머스._5_완전탐색;

public class 최소직사각형 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60,50},{30,70},{60,30},{80,40}}));
        System.out.println(solution(new int[][]{{10,7},{12,3},{8,15},{14,7},{5,15}}));
        System.out.println(solution(new int[][]{{14,4},{19,6},{6,16},{18,7},{7,11}}));
    }

    public static int solution(int[][] sizes) {
        int answer = 0;

        // 가로, 세로 중 더 큰 값이 0번째에 오도록 만들기
        for(int[] size: sizes) {
            if(size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }

        // 0번째 인덱스에서 가장 큰 값, 1번째 인덱스에서 가장 큰 값 곱하기
        int max0 = 1;
        int max1 = 1;
        for (int[] size: sizes) {
            if(size[0] > max0) {
                max0 = size[0];
            }
            if(size[1] > max1) {
                max1 = size[1];
            }
        }
        answer = max0 * max1;

        return answer;
    }
}
