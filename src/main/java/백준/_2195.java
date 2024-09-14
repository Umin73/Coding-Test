package 백준;

import java.util.Scanner;

public class _2195 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String P = sc.next();
        int answer = 0;

        int idx = 0;
        while(idx < P.length()) {
            for (int i = P.length() - idx; i > 0; i--) {
                String temp = P.substring(idx, idx + i);
                if(S.contains(temp)) {
                    answer++;
                    idx += i;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
