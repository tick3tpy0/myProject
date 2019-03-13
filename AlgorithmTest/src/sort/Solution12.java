/*
 * 좌표 정렬하기
 */
package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Solution12 {
    static int i, N;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Point[] point = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            point[i] = new Point(x, y);
        }
        Arrays.sort(point);
        for (Point p : point) {
            System.out.println(p.x + " , " + p.y);
        }
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        System.out.println("this x : " + this.x);
        System.out.println("o x : " + o.x);
        if (this.x < o.x) {
            return -1;
        } else if (this.x == o.x) {
            if (this.y < o.y) {
                return -1;
            } else if (this.y == o.y) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
