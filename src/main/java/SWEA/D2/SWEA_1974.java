package SWEA.D2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SWEA_1974 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[][] arr = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 가로 줄 검사
            boolean flag = true;
            for (int i = 0; i < 9; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < 9; j++) {
                    if(map.containsKey(arr[i][j])) flag = false;
                    else map.put(arr[i][j], 1);
                }
            }

            // 세로 줄 검사
            for (int i = 0; i < 9; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < 9; j++) {
                    if(map.containsKey(arr[j][i])) flag = false;
                    else map.put(arr[j][i], 1);
                }
            }

            // 3*3 검사
            for (int r = 0; r < 9 && flag; r += 3) {
                for (int c = 0; c < 9 && flag; c += 3) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (map.containsKey(arr[r + i][c + j])) {
                                flag = false;
                                break;
                            }
                            map.put(arr[r + i][c + j], 1);
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + ((flag) ? 1 : 0 ));
        }
    }
}
