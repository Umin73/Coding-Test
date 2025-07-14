package 알고리즘.Greedy;

import java.io.*;
public class _1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabetCntArr = new int[26];

        String[] input = br.readLine().split("");
        for(int i = 0; i < input.length; i++) {
            int idx = input[i].charAt(0) - 'A';
            alphabetCntArr[idx]++;
        }

        // 홀수개인 알파벳이 1개 초과로 존재하면 "I'm Sorry Hansoo"
        int oddNumCnt = 0;
        for (int i=0; i<alphabetCntArr.length; i++) {
            if(alphabetCntArr[i] > 0) {
                char ch = (char)('A' + i);
                if(alphabetCntArr[i] % 2 == 1) oddNumCnt++;
            }
        }

        if(oddNumCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            br.close();
            return;
        }

        char[] palindromeChar = new char[input.length];
        int idx = 0;
        int charIdx = 0;
        while(idx < alphabetCntArr.length) {
            if(alphabetCntArr[idx] > 0) {
                while(0 < alphabetCntArr[idx]) {
                    if(alphabetCntArr[idx] % 2 == 0) {
                        palindromeChar[charIdx] = (char)('A' + idx);
                        palindromeChar[palindromeChar.length - 1 - charIdx] = (char)('A' + idx);
                        charIdx++;
                        alphabetCntArr[idx] -= 2;
                    }

                    if(alphabetCntArr[idx] % 2 == 1) {
                        palindromeChar[palindromeChar.length / 2] = (char)('A'+idx);
                        alphabetCntArr[idx] -= 1;
                    }
                }
            } else idx++;
        }

        System.out.println(new String(palindromeChar));

        br.close();
    }
}
