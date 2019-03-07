import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class chickenCheck {
    static int[][] map = new int[21][21];
    static ArrayList<Pair> list = new ArrayList<Pair>();
    static int N, M, min;
    static int answer = Integer.MAX_VALUE;

    public static void search(int next, int cnt, int[][] prev) {
        int len = list.size();
        for (int i = next; i < len; i++) {
            int[][] dist = new int[N + 1][N + 1];
            for (int k = 0; k < N; k++) {
                dist[k] = Arrays.copyOf(prev[k], N + 1);
            }
            Pair node = list.get(i);
            int x = node.x;
            int y = node.y;

            // 치킨 거리 없데이트 && 도시 치킨 거리 반환
            int sum = totalDist(x, y, dist);
            if (cnt + 1 == M) {
                if (sum < min) {
                    min = sum;
                }
            } else {
                search(i + 1, cnt + 1, dist);
            }
        }
    }

    public static int totalDist(int x, int y, int[][] dist) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) { // 집인 경우
                    int k = Math.abs(y - i) + Math.abs(x - j);
                    if (dist[i][j] > k) {
                        dist[i][j] = k;

                    }
                    sum += dist[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    list.add(new Pair(i, j));
                }
            }
        }
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], 9999);
        }
        search(0, 0, dist);
        System.out.println(min);
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
