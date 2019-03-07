
/* 
[sample input]
5 3 JCA
JCEGE
IAWEJ
GWEAQ
ZXCJM
IEOPW
[output]
2
 */
import java.util.Scanner;

public class findChar {
    static int N, M;
    static char[][] map = new char[21][21];
    static int[][] visited = new int[21][21];
    static char[] word;
    static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static int answer;
    static int cnt = 0;

    public static void dfs(int n, int y, int x) {
        System.out.println(String.format("map 1 [%d][%d] : %s", y, x, map[y][x]));
        // 종료 조건
        if (n == M - 1) { // 문자열 길이와 같으면 종료+-
            cnt += 1;
            return;
        }
        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                System.out.println("ny : " + ny);
                System.out.println(String.format("map 2 [%d][%d] : %s", ny, nx, map[ny][nx]));
                if (map[ny][nx] == word[n + 1]) {
                    dfs(n + 1, ny, nx);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        word = new char[M];
        word = sc.next().toCharArray();

        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == word[0]) { // 찾고자할 문자열의 첫번째 문자와 일치할 경우 dfs 함수 호출
                    dfs(0, i, j);
                }
            }
        }
        System.out.println(cnt);
    }
}
