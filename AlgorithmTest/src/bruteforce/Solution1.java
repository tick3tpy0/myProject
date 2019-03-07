/*
 * 풀이 제목 : 일곱 난쟁이
 */
package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    static int[] arr = new int[9];
    static int[] answer = new int[7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += arr[i];
        }
        int theOthers = sum - 100; // 아홉 난쟁이 키의 합과 100을 뺀 값을 구한다. -> 원래 없던 두 난쟁이 키의 합
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (arr[i] + arr[j] == theOthers) { // 쓸데 없는 두 놈의 키를 합한 값이 theOthers의 값과 같을 경우
                    arr[i] = 0; // 충족되는 i번째 배열을 0으로 초기화
                    arr[j] = 0; // 충족되는 j번째 배열을 0으로 초기화

                }
            }
        }
        Arrays.sort(arr); // 오름차순 정렬
        sum = 0;
        for (int i = 0; i < 9; i++) {
            if (arr[i] != 0) { // 0이 아닐 경우
                System.out.println(arr[i]); // 출력
            }
        }
    }
}
