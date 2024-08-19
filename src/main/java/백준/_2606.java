package 백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2606 {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static boolean[] check = new boolean[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int com = sc.nextInt();
        int conn = sc.nextInt();

        for (int i = 0; i <= com; i++) {
            list.add(new ArrayList<Integer>());
            check[i] = false;
        }

        for (int i = 0; i < conn; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < list.get(cur).size(); i++) {
                if (!check[list.get(cur).get(i)]) {
                    queue.offer(list.get(cur).get(i));
                    check[list.get(cur).get(i)] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 2; i <= com; i++) {
            if(check[i]) answer++;
        }
        System.out.println(answer);
    }
}
