import java.util.*;
import java.io.*;

public class GrowlingGears {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();

			int ans = 0;
			double max = 0;
			for (int i = 1; i <= n; ++i) {
				int a = in.nextInt();
				int b = in.nextInt();
				int c = in.nextInt();
				
				double r = (double) b / (2.0 * a);
				double t = -a * r * r + b * r + c;
				
				if (t > max) {
					max = t;
					ans = i;
				}
			}
			
			System.out.println(ans);
		}
		
		in.close();
	}
}
