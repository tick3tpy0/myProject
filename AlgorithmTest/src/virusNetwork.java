import java.util.Scanner;

public class virusNetwork {
    static int map[][] = new int[100][100];
    static int visited[] = new int[100];
    static int N, M, V;
    static int cnt;

    public static void dfs(int i) {
        // visited[i] = 1;
        for (int j = 1; j <= N; j++) {
            if (map[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                cnt++;
                dfs(j);

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 1; i <= M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            map[v1][v2] = map[v2][v1] = 1;
        }

        dfs(1);
        System.out.println(cnt);
    }
}
