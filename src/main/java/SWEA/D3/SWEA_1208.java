package SWEA.D3;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int answer = 0;
            int dumb = sc.nextInt();
            int[] boxes = new int[100];
            for(int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
            }

            for(int i = 0; i < dumb; i++) {
                Arrays.sort(boxes);

                boxes[0] += 1;
                boxes[boxes.length - 1] -= 1;
            }
            Arrays.sort(boxes);
            answer = boxes[boxes.length-1] - boxes[0];

            System.out.println("#" + test_case + " " + answer);

        }
    }
}
