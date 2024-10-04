package 백준;

import java.util.Scanner;

public class _9082 {
    static int n;
    static int[] numArr;
    static char[] charArr;

    static int answer = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tcnt = 0; tcnt < t; tcnt++) {
            n = sc.nextInt();
            numArr = new int[n];
            charArr = new char[n];
            String input = sc.next();

            for (int i = 0; i < n; i++) {
                numArr[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
                if(numArr[i] > max) max = numArr[i];
            }

            input = sc.next();
            for (int i = 0; i < n; i++) {
                charArr[i] = input.charAt(i);
            }

            findStar();
            findMine();

            System.out.println(answer);
            answer = 0;
        }
    }

    static void findStar() {
        for (int i = 0; i < n; i++) {
            if(charArr[i] == '*') {
                reduceNum(i);
                answer++;
            }
        }
    }

    static void findMine() {
        int cur, next;
        while(!everythingIsUnderZero()) {
            for (int i = 1; i < n-2; i++) {
                if(numArr[i] == max) {
                    cur = i;
                    next = i+1;

                    if(numArr[cur-1]+numArr[cur]+numArr[cur+1] >= numArr[next-1]+numArr[next]+numArr[next+1]) {
                        reduceNum(cur);
                        answer++;
                    } else {
                        reduceNum(next);
                        i++;
                    }
                }
            }
            max--;
        }
    }

    static void reduceNum(int idx) {
        if(idx-1 >= 0) numArr[idx-1] -= 1;
        if(idx+1 < n) numArr[idx+1] -= 1;
        numArr[idx] -= 1;
    }

    static boolean everythingIsUnderZero() {
        for (int i = 0; i < n; i++) {
            if(numArr[i] > 0) return false;
        }
        return true;
    }
}
