/*
 * 순열 사이클
 */
package graph;

import java.util.Scanner;

public class Solution13 {
    static int N, cnt;
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
        for (int i = 1; i <= N; i++) {
            int j = sc.nextInt();
            map[i][j] = 1;
        }
        for (int i = 1; i <= N; i++) { // 노드의 수만큼
            if (visited[i] == false) { // 중간에 끊기면
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
