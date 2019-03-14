package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution14 {
    static int N;
    static Queue<Character> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Character> tmp = new ArrayList<Character>();
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            if (cmd.contains("push")) {
                char x = cmd.charAt(5);
                que.add(x);
                tmp.add(x); // 배열에 담아놈
            } else if (cmd.equals("front")) {
                if (que.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(que.peek());
                }
            } else if (cmd.equals("back")) {
                if (que.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println((tmp.get(tmp.size() - 1))); // 담아논 배열의 가장 마지막 원소를 가져옴
                }
            } else if (cmd.equals("pop")) {
                if (que.isEmpty()) {
                    System.out.println(-1);
                } else {
                    char s = que.poll(); // 큐의 첫번째 원소를 번환하고 꺼낸다.
                    System.out.println(s);
                }
            } else if (cmd.equals("size")) {
                System.out.println(que.size());
            } else if (cmd.equals("empty")) {
                if (que.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
