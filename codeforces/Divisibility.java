import java.util.Scanner;


public class Divisibility {
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	
	static long lcm(long a, long b) {
		return a * (b / gcd(a, b));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		long n = in.nextLong();
		long lcm = 1;
		for (int i = 2; i <= 10; i++) {
			lcm = lcm(lcm, i);
		}
		long ans = n / lcm;

		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
