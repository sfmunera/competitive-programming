package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1792 (10851 - 2D Hieroglyphs decoder) */
/* SUBMISSION: 10183608 */
/* SUBMISSION TIME: 2012-06-02 17:35:15 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10851_2DHieroglyphsdecoder {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			if (first)
				first = false;
			else
				in.readLine();
			
			String[] H = new String[10];
			for (int i = 0; i < 10; ++i)
				H[i] = in.readLine();
			
			String res = "";
			for (int j = 1; j < H[0].length() - 1; ++j) {
				int ascii = 0;
				int pow = 1;
				for (int i = 1; i <= 8; ++i) {
					ascii += (H[i].charAt(j) == '/' ? 0 : 1) * pow;
					pow <<= 1;
				}
				res += (char)ascii;
			}
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}
