package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 149 (213 - Message Decoding) */
/* SUBMISSION: 10208427 */
/* SUBMISSION TIME: 2012-06-09 21:57:14 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00213_MessageDecoding {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		int k = 0;
		for (int len = 1; len <= 7; ++len)
			for (int i = 0; i < (1 << len) - 1; ++i) {
				String bin = String.format("%" + len + "s", Integer.toBinaryString(i)).replace(' ', '0');
				map.put(bin, k++);
			}
		
		String header = in.readLine().trim();
		String nextHeader = "";
		while (header != null) {
			if (header.isEmpty())
				continue;
			String message = "";
			
			while (true) {
				String line = in.readLine();
				if (line == null) {
					nextHeader = null;
					break;
				}
				if (line.isEmpty())
					continue;
				
				line = line.trim();
				if (Character.isDigit(line.charAt(0)))
					message += line;
				else {
					nextHeader = line;
					break;
				}
			}
			String ans = "";
			int n = message.length();
			int i = 0;
			while (i + 3 <= n) {
				
				int len = Integer.parseInt(message.substring(i, i + 3), 2);
				if (len == 0)
					break;
				i += 3;
				
				boolean done = false;
				while (i + len <= n && !done) {
					String token = message.substring(i, i + len);
					
					if (map.containsKey(token)) {
						int ind = map.get(token);
						if (ind < header.length())
							ans += header.charAt(ind);
					} else
						done = true;
					
					i += len;
				}
			}
			System.out.println(ans);
			header = nextHeader;
		}
		
		in.close();
		System.exit(0);
	}
}
