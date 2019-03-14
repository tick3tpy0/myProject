package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution14 {
    static int N;
    static Queue<String> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<String> tmp = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            if (cmd.contains("push")) {
                char x = cmd.charAt(5);
                que.add(String.valueOf(x));
                tmp.add(String.valueOf(x)); // 배열에 담아놈
            } else if (cmd.equals("front")) {
                if (que.isEmpty()) {
                    result.add(Integer.toString(-1));
                } else {
                    result.add(que.peek());
                }
            } else if (cmd.equals("back")) {
                if (que.isEmpty()) {
                    result.add(Integer.toString(-1));
                } else {
                    result.add((tmp.get(tmp.size() - 1))); // 담아논 배열의 가장 마지막 원소를 가져옴
                }
            } else if (cmd.equals("pop")) {
                if (que.isEmpty()) {
                    result.add(Integer.toString(-1));
                } else {
                    String s = que.poll(); // 큐의 첫번째 원소를 번환하고 꺼낸다.
                    result.add(s);
                }
            } else if (cmd.equals("size")) {
                result.add(Integer.toString(que.size()));
            } else if (cmd.equals("empty")) {
                if (que.isEmpty()) {
                    result.add(Integer.toString(1));
                } else {
                    result.add(Integer.toString(0));
                }
            }
        }
        if (!result.isEmpty()) {
            for (String idx : result) {
                System.out.println(idx);
            }
        }
    }
}
