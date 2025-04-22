package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _12919 {
    static String S;
    static String T;
    static int answer = 0; // 바꿀 수 있으면 1, 없으면 X
    static Set<String> set = new HashSet<String>();

    static void solution(String t) {
        if(t.equals(S)) {
            answer = 1;
            return;
        }
        if(t.length() == S.length()) {
            return;
        }

        if(t.endsWith("A")) {
            solution(t.substring(0, t.length()-1));
        }
        if(t.startsWith("B")) {
            solution(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        solution(T);

        System.out.println(answer);
        br.close();
    }
}
