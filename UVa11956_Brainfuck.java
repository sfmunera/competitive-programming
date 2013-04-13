package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3107 (11956 - Brainfuck) */
/* SUBMISSION: 11503020 */
/* SUBMISSION TIME: 2013-03-25 01:47:11 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11956_Brainfuck {
	
	static String toHex(int x) {
		String hex = "0123456789ABCDEF";
		String ans = "";
		
		for (int i = 0; i < 2; ++i) {
			ans = hex.charAt(x % 16) + ans;
			x /= 16;
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String program = in.readLine();
			
			int[] memo = new int[100];
			int pointer = 0;
			
			for (int i = 0; i < program.length(); ++i) {
				if (program.charAt(i) == '>') pointer = (pointer + 1) % 100;
				else if (program.charAt(i) == '<') pointer = (pointer - 1 + 100) % 100;
				else if (program.charAt(i) == '+') memo[pointer] = (memo[pointer] + 1) % 256;
				else if (program.charAt(i) == '-') memo[pointer] = (memo[pointer] - 1 + 256) % 256;
				//else if (program.charAt(i) == '.') memo[pointer] = (memo[pointer] + 1) % 256;
			}
			
			System.out.print("Case " + t + ":");
			for (int i = 0; i < 100; ++i)
				System.out.print(" " + toHex(memo[i]));
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
