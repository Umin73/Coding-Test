package 알고리즘.구현;

import java.io.*;
import java.util.*;

public class _5430 {

    static int T, N;
    static String[] funcArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            funcArr = br.readLine().split("");
            N = Integer.parseInt(br.readLine());

            String numArr = br.readLine().replace("[","").replace("]","");
            String[] splitNumArr = numArr.split(",");

            Deque<Integer> deque = new ArrayDeque<>();
            for(int i = 0; i < splitNumArr.length; i++) {
                if(splitNumArr[i].isEmpty()) break;
                deque.offer(Integer.parseInt(splitNumArr[i]));
            }

            boolean errorFlag = false;
            boolean numListReverse = false;
            for(int i=0; i<funcArr.length; i++) {
                if(funcArr[i].equals("R")) {
                    numListReverse = !numListReverse;
                } else {
                    if(deque.isEmpty()) {
                        errorFlag = true;
                        break;
                    }
                    if(numListReverse) deque.pollLast();
                    else deque.pollFirst();
                }
            }
            if(errorFlag) System.out.println("error");
            else {
                StringBuilder answer = new StringBuilder("[");
                if(numListReverse) {
                    while(!deque.isEmpty()){
                        answer.append(deque.pollLast());
                        if(!deque.isEmpty()) answer.append(",");
                    }
                }
                else {
                    while(!deque.isEmpty()){
                        answer.append(deque.poll());
                        if(!deque.isEmpty()) answer.append(",");
                    }
                }
                answer.append("]");
                System.out.println(answer);
            }
        }

        br.close();
    }
}
