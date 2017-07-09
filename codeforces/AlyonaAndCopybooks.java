import java.util.*;

public class AlyonaAndCopybooks {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong();
		long a = in.nextLong();
		long b = in.nextLong();
		long c = in.nextLong();
		long ans = 0;
		
		if (n % 4 == 1) {
			ans = Math.min(3 * a, Math.min(a + b, c));
		} else if (n % 4 == 2) {
			ans = Math.min(2 * a, Math.min(b, 2 * c));
		} else if (n % 4 == 3) {
			ans = Math.min(a, Math.min(b + c, 3 * c));
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
