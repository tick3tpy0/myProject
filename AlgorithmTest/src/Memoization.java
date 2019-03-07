import java.util.HashMap;

public class Memoization {
    static int cnt = 0, index = 50, temp = 0;
    static double before, after = 0; // 시간 측정용

    public static void main(String[] args) {

        // 일반 피보나치 재귀함수
        before = System.currentTimeMillis();
        temp = fn_Fibonacci(index);
        after = System.currentTimeMillis();
        System.out.println("1. 피보나치\nf(" + index + ")일 때, 결과값 : " + temp + "\n함수 호출 횟수 : " + cnt + ", 수행시간 : " + (after - before) + "ms");
        cnt = 0;
        temp = 0;

        // DP 피보나치 재귀함수
        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>(); // 중복연산 방지

        before = System.currentTimeMillis();
        temp = fn_DP_Fibonacci(index, dp);
        after = System.currentTimeMillis();
        System.out.println("\n2. 동적계획법 피보나치\nf(" + index + ")일 때, 결과값 : " + temp + "\n함수 호출 횟수 : " + cnt + ", 수행시간 : " + (after - before) + "ms");

    }

    public static int fn_Fibonacci(int n) {
        cnt++;
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            return fn_Fibonacci(n - 1) + fn_Fibonacci(n - 2);
        }
    }

    public static int fn_DP_Fibonacci(int n, HashMap<Integer, Integer> dp) {
        cnt++;
        if (dp.containsKey(n)) { // 이미 연산했던 적이 있다면, 그 값을 꺼내 돌려준다.
            return dp.get(n);
        } else if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            int value = fn_DP_Fibonacci(n - 1, dp) + (fn_DP_Fibonacci(n - 2, dp));
            dp.put(n, value);
            return value;
        }
    }

}
