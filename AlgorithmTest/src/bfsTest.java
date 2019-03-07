
/* 
보물섬
[sample input]
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
[output]
8
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsTest {
    static int N, M;
    static char map[][] = new char[21][21];

    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { -1, 1, 0, 0 }; // 왼쪽, 오른쪽, 위, 아래
    static int result = 0;

    public static void bfs(int y, int x) {
        Queue<Point> que = new LinkedList<Point>();
        que.add(new Point(y, x, 0));
        boolean[][] visited = new boolean[N][M];
        visited[y][x] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            y = p.y;
            x = p.x;
            result = Math.max(result, p.cnt);
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + x;
                int ny = dy[k] + y;
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[ny][nx] == 'L' && !visited[ny][nx]) { // 맵에서 육지일때와 visited가 false일때(방문하지 않았을때)
                        visited[ny][nx] = true;
                        que.add(new Point(ny, nx, p.cnt + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    // System.out.println(String.format("map[%d][%d] : %s", i, j, map[i][j]));
                    bfs(i, j);
                }
            }
        }
        System.out.println(result - 1);
    }
}
