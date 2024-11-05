package SWEA.D2;

import java.util.*;

public class SWEA_1204 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T, input;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < 1000; i++) {
                input = sc.nextInt();
                map.put(input, map.getOrDefault(input, 0) + 1);
            }

            int maxKey = -1;
            int maxValue = -1;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() > maxValue || (entry.getValue() == maxValue && entry.getKey() > maxKey)) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }

            System.out.println("#" + n + " " + maxKey);
        }
    }
}
