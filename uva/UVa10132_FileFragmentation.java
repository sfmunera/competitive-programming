package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1073 (10132 - File Fragmentation) */
/* SUBMISSION: 10217042 */
/* SUBMISSION TIME: 2012-06-12 16:19:13 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10132_FileFragmentation {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		while (T-- > 0) {
			List<String> fragments = new ArrayList<String>();
			Map<String, Integer> count = new HashMap<String, Integer>();
			while (true) {
				String line = in.readLine();
				if (line == null || line.isEmpty())
					break;
				fragments.add(line);
			}
			
			int N = fragments.size();
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					if (i != j) {
						String file = fragments.get(i) + fragments.get(j);
						
						if (count.containsKey(file)) {
							int val = count.get(file);
							count.put(file, val + 1);
						} else
							count.put(file, 1);
					}
			
			if (first)
				first = false;
			else
				System.out.println();
			for (String f : count.keySet())
				if (count.get(f) >= N / 2) {
					System.out.println(f);
					break;
				}
		}
		
		in.close();
		System.exit(0);
	}
}
