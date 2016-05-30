package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 55 (119 - Greedy Gift Givers) */
/* SUBMISSION: 09981434 */
/* SUBMISSION TIME: 2012-04-11 21:10:54 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00119_GreedyGiftGivers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		boolean first = true;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			Map<String, Integer> give = new TreeMap<String, Integer>();
			Map<String, Integer> receive = new TreeMap<String, Integer>();
			
			String[] parts = in.readLine().split("[ ]+");
			for (String p : parts) {
				give.put(p, 0);
				receive.put(p, 0);
			}
			
			for (int i = 0; i < N; ++i) {
				String[] parts2 = in.readLine().split("[ ]+");
				String name = parts2[0];
				int budget = Integer.parseInt(parts2[1]);
				int m = Integer.parseInt(parts2[2]);
				
				if (m != 0) {
					int toGive = budget / m;
					give.put(name, toGive * m);
					
					for (int j = 0; j < m; ++j) {
						String who = parts2[3 + j];
						int cur = receive.get(who);
						receive.put(who, cur + toGive);
					}
				}
			}
			
			if (first)
				first = false;
			else
				System.out.println();
			
			for (String p : parts)
				System.out.printf("%s %d\n", p, receive.get(p) - give.get(p));
		}
		
		in.close();
		System.exit(0);
	}
}
