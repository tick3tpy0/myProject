import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bombDfs {
    static int N, M;
    static int[][] map = new int[21][21];
    static int[] bx = new int[21];
    static int[] by = new int[21];
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { -1, 1, 0, 0 }; // 왼쪽, 오른쪽, 위, 아래
    static int result = 0;

    public static void dfs(int x, int y) {
        System.out.println(String.format("map 1 [%d][%d] : %d", x, y, map[x][y]));
        Queue<Node1> que = new LinkedList<Node1>();
        que.add(new Node1(x, y));
        boolean[][] visited = new boolean[N + 1][N + 1];
        visited[x][y] = true;
        if (map[x][y] != 0) {
            result += map[x][y];
        }
        while (!que.isEmpty()) {
            Node1 p = que.poll();
            y = p.y;
            x = p.x;
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + x;
                int ny = dy[k] + y;
                if (nx >= 0 && nx < N + 1 && ny >= 0 && ny < N + 1) {
                    System.out.println(String.format("map 2 [%d][%d] : %d", x, y, map[x][y]));
                    if (!visited[nx][ny]) {
                        System.out.println(String.format("map 3 [%d][%d] : %d", nx, ny, map[nx][ny]));
                        visited[nx][ny] = true;
                        que.add(new Node1(nx, ny));
                        break;
                        // result += map[x][y];
                        // map[nx][ny] = 0;

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 1; i <= M; i++) {
            bx[i] = sc.nextInt();
            by[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int k = 1; k <= M; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (bx[k] == i && by[k] == j) {
                        System.out.println("i : " + i + " j : " + j);
                        dfs(j, i);
                    }
                }
            }
        }
        System.out.println(result);
    }
}

class Node1 {
    int x;
    int y;

    Node1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
