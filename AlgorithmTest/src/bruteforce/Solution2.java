/*
 * 풀이 제목 : N과 M(1)
 */
package bruteforce;

import java.util.Scanner;

public class Solution2 {
    static int N, M;
    static int[] arr = new int[10];
    static boolean[] visited = new boolean[10];

    public static void dfs(int cnt) {
        // System.out.println("cnt : " + cnt);
        if (cnt == M) { // 현재 몇개를 뽑았는지를 카운트해준다.
            for (int i = 0; i < M; i++) {
                System.out.println("arr[i] : " + arr[i]);
                System.out.println(arr[i] + 1);
            }
            System.out.println("");
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // visited 배열을 사용해서 중복을 피함
                visited[i] = true;
                arr[cnt] = i;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dfs(0);
    }
}
