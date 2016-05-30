package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3786 (12364 - In Braille) */
/* SUBMISSION: 11511222 */
/* SUBMISSION TIME: 2013-03-26 17:45:38 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12364_InBraille {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] toBraille = {".***..", "*.....", "*.*...", "**....", "**.*..", "*..*..", "***...", 
				"****..", "*.**..", ".**..."};
		Map<String, Integer> toDigit = new HashMap<String, Integer>();
		toDigit.put(".***..", 0);
		toDigit.put("*.....", 1);
		toDigit.put("*.*...", 2);
		toDigit.put("**....", 3);
		toDigit.put("**.*..", 4);
		toDigit.put("*..*..", 5);
		toDigit.put("***...", 6);
		toDigit.put("****..", 7);
		toDigit.put("*.**..", 8);
		toDigit.put(".**...", 9);
		
		while (true) {
			int D = Integer.parseInt(in.readLine());
			if (D == 0) break;
			
			char ch = in.readLine().charAt(0);
			if (ch == 'S') {
				String message = in.readLine();
				
				for (int i = 0; i < 3; ++i) {
					String ans = "";
					for (int j = 0; j < D; ++j) {
						if (j > 0) ans += " ";
						ans += toBraille[message.charAt(j) - '0'].substring(2 * i, 2 * (i + 1));
					}
					System.out.println(ans);
				}
			} else {
				String[] message = new String[D];
				for (int j = 0; j < D; ++j)
					message[j] = "";
				for (int i = 0; i < 3; ++i) {
					String[] parts = in.readLine().split("[ ]");
					for (int j = 0; j < D; ++j)
						message[j] += parts[j];
				}
				for (int i = 0; i < D; ++i)
					System.out.print(toDigit.get(message[i]));
				System.out.println();
			}
		}
		
		in.close();
		System.exit(0);
	}
}
