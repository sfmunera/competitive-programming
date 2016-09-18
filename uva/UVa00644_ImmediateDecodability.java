package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 585 (644 - Immediate Decodability) */
/* SUBMISSION: 10184059 */
/* SUBMISSION TIME: 2012-06-02 20:07:37 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00644_ImmediateDecodability {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int t = 1;
		while ((line = in.readLine()) != null) {
			List<String> list = new ArrayList<String>();
			list.add(line);
			
			while (!(line = in.readLine()).equals("9")) {
				list.add(line);
			}
			
			boolean ok = true;
			int N = list.size();
			for (int i = 0; i < N && ok; ++i)
				for (int j = 0; j < N && ok; ++j)
					if (i != j) {
						String str1 = list.get(i);
						String str2 = list.get(j);
						if (str1.startsWith(str2) || str2.startsWith(str1))
							ok = false;
					}
			System.out.println("Set " + t + " is " + (ok ? "" : "not ") + "immediately decodable");
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
