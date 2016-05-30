package interview;

public class ModerateTrailingZerosFactorial {
	public static void main(String[] args) {
		int n = 250;
		
		int cnt2 = 0;
		int cnt5 = 0;
		for (int i = 2; i <= n; ++i) {
			int tmp = i;
			while (tmp % 2 == 0) {
				++cnt2;
				tmp /= 2;
			}
			tmp = i;
			while (tmp % 5 == 0) {
				++cnt5;
				tmp /= 5;
			}
		}
		
		System.out.println(Math.min(cnt2, cnt5));
	}
}
