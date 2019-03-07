/*
 * 테트로미노
 */
package bruteforce;

import java.util.Scanner;

public class Solution4 {
    static int N, M;
    static int[][] map = new int[500][500];
    static boolean[][] visited = new boolean[500][500];
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int answer = 0;

    public static void dfs(int x, int y, int sum, int cnt) {
        visited[x][y] = true;
        // 1. 기저 : cnt가 3이면 멈추고 최대 총합을 answer로 세팅
        if (cnt == 3) {
            answer = Math.max(answer, sum);
        }
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (visited[nx][ny] == false) {
                    // System.out.println(sum + map[nx][ny]);
                    dfs(nx, ny, sum + map[nx][ny], cnt + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
                dfs(i, j, map[i][j], 0);
            }
        }
        System.out.println("Answer : " + answer);
    }
}
