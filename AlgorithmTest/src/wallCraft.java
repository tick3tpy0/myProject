import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class wallCraft {
    static int N, M;
    static Queue<Node> que = new LinkedList<>();
    static int[][] map = new int[21][21];
    static int[][][] visited = new int[21][21][21];
    static int min;
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { -1, 1, 0, 0 }; // 왼쪽, 오른쪽, 위, 아래
    static boolean ok;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited[0][0][1] = 1;
        que.add(new Node(0, 0, 1));
        loop: while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node current = que.poll();
                if (current.x == N - 1 && current.y == M - 1) {
                    min++;
                    ok = true;
                    break loop;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        System.out.println(map[nx][ny]);
                        if (map[nx][ny] == 1) { // 벽을 이미 부순 경우
                            if (current.d > 0 && visited[nx][ny][0] != 0) { // 드릴을 가지고 있고 방문한 적이 없다면
                                visited[nx][ny][0] = 1;
                                que.add(new Node(nx, ny, 0)); //
                            }
                        } else { // 벽을 부순 적이 없다면
                            if (visited[nx][ny][current.d] == 0) // 가지 않았던 길일 경우
                                continue;
                            visited[nx][ny][current.d] = 1;
                            que.add(new Node(nx, ny, current.d));
                        }
                    }
                }
                min++;
            }
            System.out.println(ok ? min : -1);
        }
    }
}

class Node {
    int x;
    int y;
    int d;

    Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
