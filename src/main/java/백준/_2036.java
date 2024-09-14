package 백준;

import java.util.*;

public class _2036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Long> ansArr = new ArrayList<>();
        ArrayList<Long> negativeNums = new ArrayList<>();
        ArrayList<Long> positiveNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if(input < 1) negativeNums.add((long) input);
            else positiveNums.add((long) input);
        }
        Collections.sort(negativeNums);
        Collections.sort(positiveNums, Collections.reverseOrder());

        long multiplied = 0;
        long added = 0;
        while(!negativeNums.isEmpty()) {
            if(negativeNums.size() == 1) ansArr.add(Long.valueOf(negativeNums.get(0)));
            else {
                multiplied = negativeNums.get(0) * negativeNums.get(1);
                added = negativeNums.get(0) + negativeNums.get(1);
                ansArr.add(Math.max(multiplied, added));
                negativeNums.remove(0);
            }
            negativeNums.remove(0);
        }

        while(!positiveNums.isEmpty()) {
            if(positiveNums.size() == 1) ansArr.add(Long.valueOf(positiveNums.get(0)));
            else {
                multiplied = positiveNums.get(0) * positiveNums.get(1);
                added = positiveNums.get(0) + positiveNums.get(1);
                ansArr.add(Math.max(multiplied, added));
                positiveNums.remove(0);
            }
            positiveNums.remove(0);
        }

        long answer = 0L;
        while(!ansArr.isEmpty()) {
            answer += ansArr.get(0);
            ansArr.remove(0);
        }
        System.out.println(answer);
    }
}
