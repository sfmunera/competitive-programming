package bapc;

import java.util.*;
import java.io.*;

public class Incognito {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				stk.nextToken();
				String category = stk.nextToken();
				
				if (!map.containsKey(category))
					map.put(category, 1);
				else
					map.put(category, map.get(category) + 1);
				
			}
			long ans = 1;
			for (int x : map.values())
				ans *= x + 1;
			
			System.out.println(ans - 1);
		}
		
		in.close();
	}
}
