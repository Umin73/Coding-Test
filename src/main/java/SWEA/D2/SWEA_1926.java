package SWEA.D2;

import java.util.Scanner;

public class SWEA_1926 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            String temp = Integer.toString(i);
            String []clapNum = {"3", "6", "9"};

            int count = 0;
            for(String clap: clapNum) {
                if(temp.contains(clap)) {
                    for(int j = 0; j < temp.length(); j++) {
                        if (temp.charAt(j) == clap.charAt(0)) {
                            temp.replace(clap, "");
                            count++;
                        }
                    }
                }
            }
            if(count == 0) {
                System.out.print(i + " ");
            } else {
                for (int j = 0; j < count; j++) {
                    System.out.print("-");
                }
                System.out.print(" ");
            }
        }
    }
}
