/*
 *  쇠막대기
 */
package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution10 {
    static int cnt, N, i, j;
    static int result = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char temp;
        String input = br.readLine();
        Stack<Character> stack = new Stack<Character>();
        for (i = 0; i < input.length(); i++) {
            temp = input.charAt(i);
            if (temp == '(') { // '('를 만나면
                stack.push(temp); // stack에서 push
            } else {
                stack.pop();
                temp = input.charAt(i - 1); // 한 쌍이 레이저일 경우 그 전 괄호 확인
                System.out.println("temp  : " + temp);
                if (temp == '(') { // '(' 이게 나온다면
                    result += stack.size(); // stack 크기를 result에 저장
                    System.out.println("stack size : " + stack.size());
                } else {
                    result += 1; // 막대기 끝일 경우 1을 더함
                }
            }
        }
        System.out.println("result : " + result);
    }
}
