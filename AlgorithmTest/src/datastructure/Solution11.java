/*
 * 에디터
 */
package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution11 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); // 문자열 입력 받기
        Stack<Character> Lstack = new Stack<Character>(); // 문자열 스택에 담기
        Stack<Character> Rstack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            Lstack.push(input.charAt(i)); // 문자열을 Left stack에 담기
        }
        N = Integer.parseInt(br.readLine()); // 명령어의 개수 입력
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            if (cmd.equals("L")) {
                if (!Lstack.isEmpty()) {
                    Rstack.push(Lstack.pop()); // 커서를 맨 왼쪽으로 한 칸 옮김
                }
            } else if (cmd.equals("D")) {
                if (!Rstack.isEmpty()) {
                    Lstack.push(Rstack.pop()); // 커서를 맨 오른쪽으로 한 칸 옮김
                }
            } else if (cmd.equals("B")) {
                if (!Lstack.isEmpty()) {
                    Lstack.pop(); // 커서 왼쪽에 있는 문자를 삭제함,
                }
            } else if (cmd.contains("P")) {
                char x = cmd.charAt(2);
                Lstack.push(x); // '문자'라는 문자를 커서 왼쪽에 추가함
            }
        }
        while (!Lstack.empty()) {
            Rstack.push(Lstack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!Rstack.empty()) {
            sb.append(Rstack.pop());
        }
        System.out.println(sb);
    }
}
