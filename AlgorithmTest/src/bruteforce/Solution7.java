/*
 *  수 정렬 - 퀵 소트
 */
package bruteforce;

import java.util.Scanner;

public class Solution7 {
    static int N;
    static int[] arr;

    public static void qSort(int[] arr) {
        qSort(arr, 0, arr.length - 1); // 배열, 배열의 시작 위치, 배열의 마지막 위치
    }

    public static void qSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end); // 배열의 파티션을 나누고 오른쪽 방의 첫번째 값을 받아옴
        if (start < part2 - 1) // 오른쪽 파티션이 시작점 바로 다음에서 시작한다면 왼쪽 파티션에 데이터가 하나이기 때문에 정렬할 필요가 없다. 즉 오른쪽 파티션이 시작점에서 1개이상 차이가 날때 재귀적으로 함수 호출
            qSort(arr, start, part2 - 1);
        if (part2 < end) // 오른쪽 파티션의 시작점이 마지막 배열 방보다 작은 경우에만 오른쪽 파티션을 정렬
            qSort(arr, part2, end);

    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2]; // 중간 지점 계산
        while (start <= end) {
            while (arr[start] < pivot) // 배열의 값이 피벗 값보다 작으면 무시함.
                start++;
            while (arr[end] > pivot) // 배열 방의 값이 피벗 보다 크거나 작으면 멈추고 end 움직임
                end--;
            if (start <= end) {
                swap(arr, start, end); // 두 개의 값이 마주칠때
                start++;
                end--;
            }
        }
        return start; // 오른쪽 방의 첫번째 배열 인덱스 리턴
    }

    public static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;

    }

    public static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        printArray(arr);
        qSort(arr);
        printArray(arr);
    }
}
