package livearchive;

import java.io.*;

public class ProgrammingTheEDSAC {
	
	static long ONELONG = 10000000000000000L;
	static long MIN = 152587890625L;
	static long MAX = 9999847412109375L;
	static String alphabet = "PQWERTYUIOJ#SZK*?F@D!HNM&LXGABCV";
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int P = Integer.parseInt(in.readLine());
		for (int p = 1; p <= P; ++p) {
			String[] parts = in.readLine().split("[ ]+");
			int N = parts[1].length();
			int pointpos = parts[1].indexOf('.');
			for (int i = 0; i < 16 - (N - pointpos - 1); ++i)
				parts[1] += '0';
			parts[1] = parts[1].substring(0, pointpos) + parts[1].substring(pointpos + 1);
			long code = Long.parseLong(parts[1]);
			
			System.out.print(p + " ");
			if (code < -ONELONG || code >= ONELONG) {
				System.out.println("INVALID VALUE");
				continue;
			}
			char[] binary = new char[17];
			
			if (Math.abs(code) < MIN)
				code = 0L;
			
			if (code < 0) {
				code += ONELONG;
				binary[0] = '1';
			} else
				binary[0] = '0';
			//System.out.println(code);

			for (int i = 1; i <= 16; ++i) {
				code *= 2L;
				if (code >= ONELONG)
					binary[i] = '1';
				else
					binary[i] = '0';
				code %= ONELONG;
			}
			
			String str = String.valueOf(binary);
			//System.out.println(str);
			char opcode = alphabet.charAt(Integer.parseInt(str.substring(0, 5), 2));
			int num = Integer.parseInt(str.substring(5, 16), 2);
			char size = str.charAt(16) == '1' ? 'D' : 'F';
			System.out.println(opcode + " " + num + " " + size);
		}
		
		in.close();
		System.exit(0);
	}
}
