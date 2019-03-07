/*
 *  괄호
 */
package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution6 {
    static int cnt, N, i, j;
    static char[] arr = new char[50];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (i = 0; i < N; i++) {
            boolean isVPS = true;
            char temp;
            String input = br.readLine();
            Stack<Character> stack = new Stack<Character>();
            for (j = 0; j < input.length(); j++) {
                // System.out.println(arr[j]);
                temp = input.charAt(j);
                if (temp == '(') {
                    stack.push(temp);
                } else if (temp == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        isVPS = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) // 스택이 비어있지 않다면 false
                isVPS = false;

            if (isVPS)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}
