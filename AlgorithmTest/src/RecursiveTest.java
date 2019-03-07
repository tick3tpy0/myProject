import java.util.Scanner;
import java.util.Vector;

public class RecursiveTest {
	public static void recursiveSum1(int n, Vector<Integer> picked, int toPick) {
		/* n : 전체 원소의 수
		 * picked : 지금까지 고른 원소들의 번호
		 * toPick : 더 고를 원소의 수
		 * 일 때, 앞으로 toPick개의 원소를 고르는 모든 방법을 출력
		 * 자바에서는 동적인 길이로 여러 데이터형을 저장하기 위해 Vector 클래스 제공(가변 길이의 배열)
		*/
		// 기저 사례
		System.out.println("toPick 0.1 : " + toPick);
		System.out.println("picked 0.1 : " + picked);
		if(toPick == 0) {
			System.out.println("picked 0.2 : " + picked);
			System.out.println("########## EXIT ###########");
			return;
		}
				
		// 고를 수 있는 가장 작은 번호 계산
		int smallest = picked.isEmpty() ? 0 : picked.lastElement() + 1; // True or False Check
		System.out.println("=====================");
		System.out.println("toPick 1 : " + toPick);
		System.out.println("picked 1 : " + picked);
		System.out.println("picked size 1 : " + picked.size());
		System.out.println("smallest 1 : " + smallest);
		System.out.println("*********************");
		
		// 이단계에서 원소 하나를 고른다.
		for(int next = smallest; next < n; ++next) {
			System.out.println("next : " + next);
			picked.addElement(next);
			System.out.println("toPick 2.1 : " + toPick);
			recursiveSum1(n, picked, toPick - 1);
			System.out.println(String.format("picked Size 2 : %s", picked.size() - 1));
			System.out.println("toPick 2.2 : " + toPick);
			picked.removeElementAt(picked.size() - 1);
			System.out.println("picked 2 : "  + picked);
		}
	}
	public static int recursiveSum(int n) {
		if(n == 1) // 더이상 쪼개지지 않는 최소한의 작업을 처리
			return n;
		else
			return n + recursiveSum(n - 1);
	}
	public static void main(String[] args) {
		/* 자연수 n이 주어졌을 때 1부터 n까지의 합 구하기(반복문)
		 * 필수 조건 n >= 1
		 */
		/*
		System.out.print("자연수 숫자 입력 : ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int sum = 0;
		for(int i=1; i <= num; i++) {
			sum += i;
		}
		System.out.println(sum);
		int ret = recursiveSum(num);
		System.out.println(ret);
		*/
		
		Vector<Integer> v = new Vector<Integer>();
		recursiveSum1(7, v, 2);
		
	}
}
