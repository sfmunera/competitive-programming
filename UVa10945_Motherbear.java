package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1886 (10945 - Mother bear) */
/* SUBMISSION: 09976780 */
/* SUBMISSION TIME: 2012-04-10 19:08:09 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10945_Motherbear {
	
	static boolean isPalindrome(String str) {
		int n = str.length();
		for (int i = 0; i < n / 2; ++i)
			if (str.charAt(i) != str.charAt(n - i - 1))
				return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while (!(line = in.readLine()).equals("DONE")) {
			String str = "";
			for (int i = 0; i < line.length(); ++i)
				if (Character.isLetter(line.charAt(i)))
					str += Character.toLowerCase(line.charAt(i));
			
			if (isPalindrome(str))
				System.out.println("You won't be eaten!");
			else
				System.out.println("Uh oh..");
		}
		
		in.close();
		System.exit(0);
	}
}
