package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 647 (706 - LCD Display) */
/* SUBMISSION: 08996617 */
/* SUBMISSION TIME: 2011-06-28 15:31:39 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00706_LCDDisplay {
	
	static char[][][] LCD = {
			{{' ', '-', ' '}, {'|', ' ', '|'}, {' ', ' ', ' '}, {'|', ' ', '|'}, {' ', '-', ' '}}, //0
			{{' ', ' ', ' '}, {' ', ' ', '|'}, {' ', ' ', ' '}, {' ', ' ', '|'}, {' ', ' ', ' '}}, //1
			{{' ', '-', ' '}, {' ', ' ', '|'}, {' ', '-', ' '}, {'|', ' ', ' '}, {' ', '-', ' '}}, //2
			{{' ', '-', ' '}, {' ', ' ', '|'}, {' ', '-', ' '}, {' ', ' ', '|'}, {' ', '-', ' '}}, //3
			{{' ', ' ', ' '}, {'|', ' ', '|'}, {' ', '-', ' '}, {' ', ' ', '|'}, {' ', ' ', ' '}}, //4
			{{' ', '-', ' '}, {'|', ' ', ' '}, {' ', '-', ' '}, {' ', ' ', '|'}, {' ', '-', ' '}}, //5
			{{' ', '-', ' '}, {'|', ' ', ' '}, {' ', '-', ' '}, {'|', ' ', '|'}, {' ', '-', ' '}}, //6
			{{' ', '-', ' '}, {' ', ' ', '|'}, {' ', ' ', ' '}, {' ', ' ', '|'}, {' ', ' ', ' '}}, //7
			{{' ', '-', ' '}, {'|', ' ', '|'}, {' ', '-', ' '}, {'|', ' ', '|'}, {' ', '-', ' '}}, //8
			{{' ', '-', ' '}, {'|', ' ', '|'}, {' ', '-', ' '}, {' ', ' ', '|'}, {' ', '-', ' '}}  //9
	};
	
	static char[][] digit(int d, int s) {		
		int rows = 2 * s + 3;
		int cols = s + 2;
		char[][] res = new char[rows][cols];
		
		int ki = 0;
		int kj = 0;
		int cnti = 0;
		int cntj = 0;
		for (int i = 0; i < 5; ++i) {
			if (i % 2 == 0)
				cnti = 1;
			else
				cnti = s;
			for (int k = 0; k < cnti; ++k) {
				kj = 0;
				for (int j = 0; j < 3; ++j) {
					if (j % 2 == 0)
						cntj = 1;
					else
						cntj = s;
					for (int l = 0; l < cntj; ++l) {
						res[ki][kj] = LCD[d][i][j];
						++kj;
					}
				}
				++ki;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int s = in.nextInt();
			String n = in.next();
			
			if (s == 0 && n.equals("0"))
				break;
			int len = n.length();
			
			int rows = 2 * s + 3;
			int cols = (s + 3) * len - 1;
			char[][] res = new char[rows][cols];
			char[][][] digits = new char[len][rows][s + 2];
			int k = 0;
			
			for (int i = 0; i < len; ++i)
				digits[i] = digit(n.charAt(i) - '0', s);
			
			
			for (int i = 0; i < rows; ++i) {
				k = 0;
				for (int d = 0; d < len; ++d) {
					if (d > 0)
						res[i][k++] = ' ';
					for (int j = 0; j < s + 2; ++j)
						res[i][k++] = digits[d][i][j];
				}
			}
			
			for (int i = 0; i < rows; ++i)
				System.out.println(String.valueOf(res[i]));
			System.out.println();
		}
	}
}