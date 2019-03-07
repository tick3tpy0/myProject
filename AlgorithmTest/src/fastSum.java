
public class fastSum {
	static int fastSum(int n) {
		System.out.println(n);
		if(n == 1)
			return 1;
		if(n % 2 == 1)
			return fastSum(n-1) + n; //홀수 입력이 주어질 때에는 짝수인 n-1 까지의 재귀 호출로 계산하고 n을 더해 답을 구함
		
		return 2 * fastSum(n/2) + (n/2) * (n/2);
	}
	public static void main(String[] args) {
		System.out.println(fastSum(10));
	}
}
