import java.util.Scanner;

public class ladder {
    static int N, M, H;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        map = new int[H + 1][N + 1];
        for (int x = 0; x < M; x++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
        }

    }
}
