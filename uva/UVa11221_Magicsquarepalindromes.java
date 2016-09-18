package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2162 (11221 - Magic square palindromes.) */
/* SUBMISSION: 08955426 */
/* SUBMISSION TIME: 2011-06-16 01:03:40 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11221_Magicsquarepalindromes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = Integer.parseInt(in.nextLine());
		for (int t = 1; t <= T; ++t) {
			char[] line = in.nextLine().toCharArray();
			
			int n = 0;
			for (char c : line)
				if (Character.isLetter(c))
					++n;
			boolean valid = true;
			int sqrt = (int)(Math.round(Math.sqrt(n)));
			if (sqrt * sqrt != n)
				valid = false;
			else {
				char[] chars = new char[n];
				int k = 0;
				for (char c : line)
					if (Character.isLetter(c))
						chars[k++] = c;
				
				k = 0;
				char[][] mat = new char[sqrt][sqrt];
				for (int i = 0; i < sqrt; ++i)
					for (int j = 0; j < sqrt; ++j)
						mat[i][j] = chars[k++];
				for (int i = 0; i < sqrt && valid; ++i)
					for (int j = 0; j <= i && valid; ++j) {
						if (mat[i][j] != mat[j][i] || 
								mat[i][j] != mat[sqrt - 1 - i][sqrt - 1 - j] ||
								mat[i][j] != mat[sqrt - 1 - j][sqrt - 1 - i])
							valid = false;
					}
			}
			System.out.println("Case #" + t + ":");
			System.out.println(valid ? sqrt : "No magic :(");
		}
	}
}