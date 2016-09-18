package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 562 (621 - Secret Research) */
/* SUBMISSION: 09977166 */
/* SUBMISSION TIME: 2012-04-10 22:05:24 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00621_SecretResearch {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String code = in.readLine();
			if (code.equals("1") || code.equals("4") || code.equals("78"))
				System.out.println("+");
			else if (code.endsWith("35"))
				System.out.println("-");
			else if (code.startsWith("9") && code.endsWith("4"))
				System.out.println("*");
			else if (code.startsWith("190"))
				System.out.println("?");
		}
		
		in.close();
		System.exit(0);
	}
}
