package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3911 (12467 - Secret Word) */
/* SUBMISSION: 10261357 */
/* SUBMISSION TIME: 2012-06-26 16:04:09 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12467_SecretWord {
	
	static String str;
	static int M;
	static int[] b;
	
	static void kmpPreprocess() {
		int i = 0;
		int j = -1;
		b[0] = -1;
		
		while (i < 2 * M + 1) {
			while (j >= 0 && str.charAt(i) != str.charAt(j))
				j = b[j];
			++i;
			++j;
			b[i] = j;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			str = in.readLine();
			M = str.length();
			
			String reverse = new StringBuffer(str).reverse().toString();
			str = str + "$" + reverse;
			
			b = new int[2 * M + 2];
			kmpPreprocess();
			
			int end = 0;
			for (int i = M + 1; i <= 2 * M + 1; ++i)
				end = Math.max(end, b[i]);
			
			System.out.println(reverse.substring(reverse.length() - end));
		}
		
		in.close();
		System.exit(0);
	}
}
