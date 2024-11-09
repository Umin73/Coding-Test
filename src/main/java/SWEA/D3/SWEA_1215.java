package SWEA.D3;

import java.util.Scanner;

public class SWEA_1215 {

    static char[][] palindromes;

    // 가로 확인
    public static boolean isPalindrome1
            (int r, int c, int length) {
        for(int i = 0; i < length / 2; i++) {
            if(palindromes[r][c+i] != palindromes[r][c+(length-1-i)]) return false;
        }

        return true;
    }

    // 세로 확인
    public static boolean isPalindrome2
    (int r, int c, int length) {
        for(int i = 0; i < length / 2; i++) {
            if(palindromes[r+i][c] != palindromes[r+(length-1-i)][c]) return false;
        }
        return true;
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int answer = 0;
            int palindromeLength = sc.nextInt();
            palindromes = new char[8][8];

            sc.nextLine();
            String input;
            for(int i = 0; i < 8; i++) {
                input = sc.next();
                for(int j = 0; j < 8; j++) {
                    palindromes[i][j] = input.charAt(j);
                }
            }

            // 가로 탐색
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j <= 8 - palindromeLength; j++) {
                    if(isPalindrome1(i,j,palindromeLength)) answer++;
                }
            }

            // 세로 탐색
            for(int i = 0; i <= 8 - palindromeLength; i++) {
                for(int j = 0; j < 8; j++) {
                    if(isPalindrome2(i,j,palindromeLength)) answer++;
                }
            }

            System.out.println("#" + test_case + " " + answer);

        }
    }
}
