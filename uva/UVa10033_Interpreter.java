package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 974 (10033 - Interpreter) */
/* SUBMISSION: 08997900 */
/* SUBMISSION TIME: 2011-06-29 03:04:47 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10033_Interpreter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = Integer.parseInt(in.nextLine());
		in.nextLine();
		boolean first = true;
		
		while (T-- > 0) {
			int[] registers = new int[10];
			int cursor = 0;
			String[] RAM = new String[1000];
			Arrays.fill(RAM, "000");
			int k = 0;
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (line.isEmpty())
					break;
				RAM[k++] = line;
			}
			
			int cnt = 0;
			while (cursor < RAM.length) {
				String s = RAM[cursor];
				int d1 = s.charAt(0) - '0';
				int d2 = s.charAt(1) - '0';
				int d3 = s.charAt(2) - '0';

				if (s.equals("100")) {
					++cnt;
					break;
				}

				switch (d1) {
				case 2:
					registers[d2] = d3;
					++cnt;
					break;
				case 3:
					registers[d2] = (registers[d2] + d3) % 1000;
					++cnt;
					break;
				case 4:
					registers[d2] = (registers[d2] * d3) % 1000;
					++cnt;
					break;
				case 5:
					registers[d2] = registers[d3];
					++cnt;
					break;
				case 6:
					registers[d2] = (registers[d2] + registers[d3]) % 1000;
					++cnt;
					break;
				case 7:
					registers[d2] = (registers[d2] * registers[d3]) % 1000;
					++cnt;
					break;
				case 8:
					registers[d2] = Integer.parseInt(RAM[registers[d3]]);
					++cnt;
					break;
				case 9:
					RAM[registers[d3]] = String.valueOf(registers[d2]);
					++cnt;
					break;
				case 0:
					if (registers[d3] != 0) {
						cursor = registers[d2];
						++cnt;
						continue;
					}
					++cnt;
					break;
				}
				++cursor;
				//System.out.println(s + ", " + cnt + ": " + Arrays.toString(registers));
			}
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(cnt);
		}
	}
}