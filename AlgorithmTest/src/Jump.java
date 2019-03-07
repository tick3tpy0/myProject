import java.util.Scanner;

public class Jump {
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { -1, 1, 0, 0 }; // 왼쪽, 오른쪽, 위, 아래

    public static int dfs(int y, int x) {
        if (y == 0 && x == 0) {
            return 1;
        }
        if (visited[y][x] == 0) {
            visited[y][x] = 1;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[y][x] < map[ny][nx]) {
                        System.out.println("=======================");
                        System.out.println("1 : " + map[ny][nx]);
                        System.out.println("2 : " + dfs(ny, nx));
                        System.out.println("3 : " + visited[y][x]);
                        visited[y][x] += dfs(ny, nx);
                    }
                }
            }
        }
        return visited[y][x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                visited[i][j] = 0;
            }
        }
        System.out.println(dfs(N - 1, M - 1));
    }
}
