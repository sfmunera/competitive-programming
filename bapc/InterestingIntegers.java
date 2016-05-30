import java.util.*;
import java.io.*;

public class InterestingIntegers {
	
	static final int MAX_FIB = 46;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		long[] fib = new long[MAX_FIB];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < MAX_FIB; ++i) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
				
		int T = in.nextInt();
		while (T-- > 0) {
			long n = in.nextLong();
			
			long g1 = 0;
			long g2 = 0;
			boolean done = false;
			for (int f = MAX_FIB - 1; f > 2 && !done; --f) {
				for (long g = 1; ; ++g) {
					long num = n - fib[f - 1] * g;
					if (num <= 0) break;
					if (num % fib[f - 2] == 0 && num / fib[f - 2] <= g) {
						g1 = num / fib[f - 2];
						g2 = g;
						done = true;
						break;
					}
				}
			}
			System.out.println(g1 + " " + g2);
		}
		
		in.close();
	}
}
