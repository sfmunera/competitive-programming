package livearchive;

import java.util.*;

public class Triples {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Map<Integer, Integer> squares = new HashMap<Integer, Integer>();
		for (int i = 0; i <= 100; ++i)
			squares.put(i * i, i);
		
		while (in.hasNext()) {
			int m = in.nextInt();
			int n = in.nextInt();
		
			int ans = 0;
			for (int x = 0; x <= m; ++x) {
				for (int y = x; y <= m; ++y) {
					int z2 = x * x + y * y;
					if (squares.containsKey(z2)) {
						int z = squares.get(z2);
						if (y <= z && z <= m)
							++ans;
					}
				}
			}
			ans += (n - 2) * (m + 1);
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
