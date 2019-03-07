
/* 
연구소
[sample input]
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
[output]
27
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class virusSpread {
    public static final int BLANK = 0; // 빈칸
    public static final int WALL = 1; // 벽
    public static final int VIRUS = 2; // 바이러스
    static int[][] map = new int[21][21];
    static int[][] visited = new int[21][21];
    static int N, M;
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { -1, 1, 0, 0 }; // 왼쪽, 오른쪽, 위, 아래
    public static int answer;

    public static void dfs(int cnt) {
        if (cnt == 3) { // 기둥이 3개일 때 bfs로 탐색해서 바이러스를 퍼트림
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == BLANK) { // 다시 0인 것 중에
                    visited[i][j] = WALL; // 안전구역이면 벽을 세우고
                    System.out.println(String.format("visited[%d][%d] : %d", i, j, visited[i][j]));
                    System.out.println("CNT : " + cnt);
                    dfs(cnt + 1);
                    visited[i][j] = BLANK; // 탐색을 마치고 나오면 다시 벽 복구
                }
            }
        }
    }

    public static void bfs() {
        int[][] virusMap = new int[N][M]; // 바이러스 MAP 생성
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = visited[i][j]; // 현재 기둥이 설치된 visited 배열을 virusmap으로 복사
            }
        }
        Queue<Integer> que1 = new LinkedList<Integer>();
        Queue<Integer> que2 = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == VIRUS) { // 큐에 바이러스의 초기위치 넣음
                    que1.add(i);
                    que2.add(j);
                }
            }
        }
        // 복사한 맵에 바이러스 터트림
        while (!que1.isEmpty() && !que2.isEmpty()) {
            int x = que1.poll();
            int y = que2.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (virusMap[nx][ny] == BLANK) { // 주변이 0일때
                        virusMap[nx][ny] = VIRUS; // 바이러스를 퍼트림
                        que1.add(nx);
                        que2.add(ny);
                    }
                }
            }
        }
        callAnswer(virusMap);
    }

    public static void callAnswer(int[][] virusMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == BLANK) { //
                    ++cnt;
                }
            }
        }
        answer = Math.max(cnt, answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = visited[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == BLANK) { // 0인 것중에
                    visited[i][j] = WALL; // 1을 대입
                    // System.out.println(String.format("map[%d][%d] : %d", i, j, map[i][j]));
                    // System.out.println(String.format("visited[%d][%d] : %d", i, j, visited[i][j]));
                    dfs(1);
                    visited[i][j] = BLANK;
                }
            }
        }
        System.out.println(answer);
    }
}
