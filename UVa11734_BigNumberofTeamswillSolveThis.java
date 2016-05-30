package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2834 (11734 - Big Number of Teams will Solve This) */
/* SUBMISSION: 08955143 */
/* SUBMISSION TIME: 2011-06-15 22:17:02 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11734_BigNumberofTeamswillSolveThis {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = Integer.parseInt(in.nextLine());
		for (int t = 1; t <= T; ++t) {
			String team = in.nextLine();
			String judge = in.nextLine();
			
			System.out.print("Case " + t + ": ");
			if (team.equals(judge))
				System.out.println("Yes");
			else {
				String noSpacesTeam = "";
				String noSpacesJudge = "";
				for (char c : team.toCharArray())
					if (c != ' ')
						noSpacesTeam += c;
				for (char c : judge.toCharArray())
					if (c != ' ')
						noSpacesJudge += c;
				if (noSpacesTeam.equals(noSpacesJudge))
					System.out.println("Output Format Error");
				else
					System.out.println("Wrong Answer");
			}
		}
	}
}