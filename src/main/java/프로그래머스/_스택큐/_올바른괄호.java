package 프로그래머스._스택큐;

import java.io.*;
import java.util.*;

public class _올바른괄호 {

    static boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        String[] strArr = s.split("");

        for(int i=0; i<strArr.length; i++) {
            if(strArr[i].equals("(")) stack.offer('(');
            else if(strArr[i].equals(")")) {
                if(stack.isEmpty()) return false;
                stack.pollLast();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().replace("\"","");

        System.out.println(solution(input));

        br.close();
    }
}
