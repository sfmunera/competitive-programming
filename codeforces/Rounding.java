import java.util.*;

public class Rounding {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int last = n % 10;
		n -= last;
		if (last > 5) {
			n += 10;
		}
		System.out.println(n);
		
		in.close();
		System.exit(0);
	}
}
