package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1975 (11034 - Ferry Loading IV) */
/* SUBMISSION: 11034988 */
/* SUBMISSION TIME: 2012-12-16 01:12:21 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11034_FerryLoadingIV {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			int l = Integer.parseInt(parts[0]) * 100;
			int m = Integer.parseInt(parts[1]);
			
			List<Queue<Integer>> Q = new ArrayList<Queue<Integer>>();
			for (int i = 0; i < 2; ++i)
				Q.add(new LinkedList<Integer>());
			for (int i = 0; i < m; ++i) {
				parts = in.readLine().split("[ ]+");
				int x = Integer.parseInt(parts[0]);
				if (parts[1].equals("left"))
					Q.get(0).offer(x);
				else
					Q.get(1).offer(x);
			}
			
			int i = 0;
			for (; !Q.get(0).isEmpty() || !Q.get(1).isEmpty(); ++i) {
				int len = 0;
				while (!Q.get(i % 2).isEmpty()) {
					if (len + Q.get(i % 2).peek() <= l)
						len += Q.get(i % 2).poll();
					else
						break;
				}
			}
			System.out.println(i);
		}
		
		in.close();
		System.exit(0);
	}
}
