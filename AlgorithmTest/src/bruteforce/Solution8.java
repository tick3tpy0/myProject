/*
 * 연결 요소의 개수
 */
package bruteforce;

import java.util.Scanner;

public class Solution8 {
    static int N, M;
    static int[][] map = new int[100][100];
    static boolean[] visited = new boolean[100];

    public static void dfs(int i) {
        visited[i] = true;
        for (int j = 1; j <= N; j++) {
            if (map[i][j] == 1 && visited[j] == false) {
                dfs(j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) { // 노드의 수만큼
            if (visited[i] == false) { // 중간에 끊기면
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
