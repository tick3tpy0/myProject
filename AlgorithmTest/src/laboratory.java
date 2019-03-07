import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class laboratory {
    static int[][] map = new int[21][21];
    static int[][] visited = new int[21][21];
    static int N, M;
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { -1, 1, 0, 0 }; // 왼쪽, 오른쪽, 위, 아래
    public static int answer;

    public static void dfs(int cnt) {
        if (cnt == 3) { // 벽이 3개를 다 세우면 bfs로 이동해서 바이러스를 터트림
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 빈칸 인 것 중
                    visited[i][j] = 1; // 방문한 곳에 벽을 세움
                    // System.out.println(String.format("visited[%d][%d] : %d", i, j, visited[i][j]));
                    // System.out.println("CNT : " + cnt);
                    dfs(cnt + 1);
                    visited[i][j] = 0; // 다시 빈칸으로 세팅
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
        Queue<Points> que = new LinkedList<Points>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 2) {
                    que.add(new Points(i, j)); // 큐에 바이러스 초기 위치 넣음
                }
            }
        }
        while (!que.isEmpty()) {
            Points p = que.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (virusMap[nx][ny] == 0) { // 주변이 빈칸일 때
                        virusMap[nx][ny] = 2; // 바이러스를 퍼트림
                        que.add(new Points(nx, ny));
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
                if (virusMap[i][j] == 0) {
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
                if (map[i][j] == 0) { // 빈칸인 것 중
                    visited[i][j] = 1; // 방문한 곳에 벽을 세움
                    dfs(1);
                    visited[i][j] = 0; // 다시 빈칸으로 세팅
                }
            }
        }
        System.out.println(answer);
    }
}

class Points {
    int x;
    int y;

    Points(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
