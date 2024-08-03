package _2_스택큐;

import java.util.ArrayList;
import java.util.Arrays;

public class 같은_숫자는_싫어 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[]{4, 4, 4, 3, 3})));
    }

    static public Object[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<arr.length; i++) {
            if(!list.isEmpty()) {
                if(arr[i-1] != arr[i])
                    list.add(arr[i]);
            } else {
                list.add(arr[i]);
            }
        }

        return list.toArray();
    }
}
