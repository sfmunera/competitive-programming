package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1129 (10188 - Automated Judge Script) */
/* SUBMISSION: 09001271 */
/* SUBMISSION TIME: 2011-06-30 03:15:33 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10188_AutomatedJudgeScript {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (true) {
			int n = Integer.parseInt(in.nextLine());
			if (n == 0)
				break;
			
			String[] correctLines = new String[n];
			for (int i = 0; i < n; ++i)
				correctLines[i] = in.nextLine();
			
			int m = Integer.parseInt(in.nextLine());
			String[] teamLines = new String[m];
			for (int i = 0; i < m; ++i)
				teamLines[i] = in.nextLine();
			
			boolean ac = true;
			
			if (m != n)
				ac = false;
			else {
				for (int i = 0; i < n && ac; ++i)
					if (!correctLines[i].equals(teamLines[i]))
						ac = false;
			}
			if (ac)
				System.out.println("Run #" + t + ": Accepted");
			else {
				String digits1 = "";
				String digits2 = "";
				for (int i = 0; i < n; ++i)
					for (int j = 0; j < correctLines[i].length(); ++j)
						if (Character.isDigit(correctLines[i].charAt(j)))
							digits1 += correctLines[i].charAt(j);
				for (int i = 0; i < m; ++i)
					for (int j = 0; j < teamLines[i].length(); ++j)
						if (Character.isDigit(teamLines[i].charAt(j)))
							digits2 += teamLines[i].charAt(j);
				if (digits1.equals(digits2))
					System.out.println("Run #" + t + ": Presentation Error");
				else
					System.out.println("Run #" + t + ": Wrong Answer");
			}
			
			++t;
		}
	}
}