/*
 *  풀이제목 : 날짜 계산
 */
package bruteforce;

import java.util.Scanner;

public class Solution3 {
    static int E, S, M;
    static int year = 1;

    public static void solve() {

        while (true) {
            if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0) {
                break;
            }
            year++;
            System.out.println(year);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        E = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();
        solve();

    }
}
