import java.util.Scanner;

public class dooduji {
    static int N;
    static int[][] map = new int[40][40];
    static int[] visited = new int[100];
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { -1, 1, 0, 0 }; // 왼쪽, 오른쪽, 위, 아래
    static int total = 1;

    public static void dfs(int y, int x) {
        if (map[y][x] == 0) {
            return;
        }
        // System.out.println(visited[1]);
        visited[total]++;

        // System.out.println(String.format("visited[%s] : %s", total, visited[total]));
        map[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            dfs(y + dy[i], x + dx[i]);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j);
                    total++;
                    // System.out.println("total 1 : " + total);
                }
            }
        }
        /*
        System.out.println(total - 1);
        for (int i = 1; i < total; i++) {
            System.out.println(visited[i]);
        }
        */
    }
}
