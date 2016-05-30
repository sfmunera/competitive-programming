package livearchive;

import java.util.*;
import java.io.*;

public class DecodingEDSACData {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String alphabet = "PQWERTYUIOJ#SZK*?F@D!HNM&LXGABCV";
		int P = Integer.parseInt(in.readLine());
		for (int p = 1; p <= P; ++p) {
			String[] parts = in.readLine().split("[ ]+");
			int opcode = alphabet.indexOf(parts[1].charAt(0));
			int num = Integer.parseInt(parts[2]);
			int size = parts[3].charAt(0) == 'D' ? 1 : 0;
			
			String str = String.format("%5s", Integer.toBinaryString(opcode)).replace(" ", "0") + 
						 String.format("%11s", Integer.toBinaryString(num)).replace(" ", "0") + size;
			//System.out.println(str);
			
			boolean negative = str.charAt(0) == '1';
			double pow = 0.5;
			double ans = 0.0;
			for (int i = 1; i <= 16; ++i) {
				ans += pow * (str.charAt(i) - '0');
				pow *= 0.5;
			}
			int pointpos = 1;
			if (negative) {
				ans -= 1.0;
				++pointpos;
			}
			
			String sans = String.format(Locale.ENGLISH, "%.17f", ans);
			int k = sans.length() - 1;
			while (k > pointpos + 1 && sans.charAt(k) == '0')
				--k;
			
			System.out.printf(Locale.ENGLISH, "%d %s\n", p, sans.substring(0, k + 1));
		}
		
		in.close();
		System.exit(0);
	}
}
