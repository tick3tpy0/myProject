import java.util.Scanner;

public class RockFestival {

    public static void main(String[] args) {
        System.out.print("테스트 케이스 숫자 입력 : ");
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        input.nextLine();
        double[] results = new double[cases]; // 결과를 넣어놀 배열

        for (int k = 0; k < cases; k++) {
            System.out.print("공연장 대여 가능일수 및 최소 공연일 수 입력(ex 6 2) : ");
            int n = input.nextInt(); // 공연장 대여 가능일 수
            int l = input.nextInt(); // 최소 공연일 수
            // System.out.println(String.format("%d, %d",n, l));
            int[] day = new int[n]; // 공연장을 대여할 수 있는 날들의 배열
            System.out.println("일별 공연장 대여비 순차적 입력 : ");
            for (int i = 0; i < n; i++) { // 일별 공연장 대여비 입력
                day[i] = input.nextInt();
                if (!input.hasNextLine())
                    break;
            }

            double min = 0; // 평균의 최소값
            for (int i = l; i <= n; i++) { // 최소 일수를 늘려간다
                for (int j = 0; j <= n - i; j++) { // 0부터 n-m 만큼의 가짓수가 나온다
                    int total = 0;
                    for (int m = 0; m < i; m++) { // i만큼(최소 일수 만큼) 더한다.
                        total += day[j + m];

                    }
                    double avg = (total / (double) i);
                    if (min == 0) // 최소값이 0과 같으면 평균값 입력해서 다음 평균값과 비교
                        min = avg;
                    else {
                        if (avg < min) // 다음 평균값고 현재 평균값보다 작을 경우
                            min = avg;
                    }

                }
            }

            results[k] = min;
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(String.format("%.12f", results[i]));
        }

        input.close();
    }
}
