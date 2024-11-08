package SWEA.D3;

import java.util.Scanner;

public class SWEA_1244 {

    static char[] numArr;
    static String num;
    static int move;
    static int answer;

    public static void swap(int a, int b) {
        char temp = numArr[a];
        numArr[a] = numArr[b];
        numArr[b] = temp;
    }

    public static void dfs(int idx, int cnt) {
        if(cnt == move) {
            String tempStr = String.valueOf(numArr);
            int tempNum = Integer.parseInt(tempStr);

            answer = Math.max(answer ,tempNum);
            return;
        }
        for(int i=idx; i<numArr.length; i++) {
            for(int j=i+1; j<numArr.length; j++) {
                swap(i,j);
                dfs(i, cnt+1);
                swap(i,j);
            }
        }
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            num = sc.next();
            move = sc.nextInt();

            numArr = new char[num.length()];
            for(int i=0; i<num.length(); i++) {
                numArr[i] = num.charAt(i);
            }

            answer = 0;
            dfs(0,0);

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
