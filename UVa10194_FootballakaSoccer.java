package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1135 (10194 - Football (aka Soccer)) */
/* SUBMISSION: 11034782 */
/* SUBMISSION TIME: 2012-12-15 22:14:14 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10194_FootballakaSoccer {
	
	static class Team implements Comparable<Team> {
		String name;
		int wins, loses, ties, played, scored, against, points, diff;
		public Team(String name) {
			this.name = name;
			this.wins = 0;
			this.loses = 0;
			this.ties = 0;
			this.played = 0;
			this.scored = 0;
			this.against = 0;
			this.points = 0;
			this.diff = 0;
		}
		public void update(int scored, int against) {
			++this.played;
			this.scored += scored;
			this.against += against;
			if (scored > against) {
				++this.wins;
				this.points += 3;
			} else if (scored < against)
				++this.loses;
			else {
				++this.ties;
				++this.points;
			}
			this.diff = this.scored - this.against;
		}
		public int compareTo(Team t) {
			if (this.points != t.points) return t.points - this.points;
			if (this.wins != t.wins) return t.wins - this.wins;
			if (this.diff != t.diff) return t.diff - this.diff;
			if (this.scored != t.scored) return t.scored - this.scored;
			if (this.played != t.played) return this.played - t.played;
			return this.name.toLowerCase().compareTo(t.name.toLowerCase());
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
		
		boolean first = true;
		int N = Integer.parseInt(in.readLine());
		while (N-- > 0) {
			String tourName = in.readLine();
			Map<String, Integer> teamId = new HashMap<String, Integer>();
			int T = Integer.parseInt(in.readLine());
			Team[] teams = new Team[T];
			for (int i = 0; i < T; ++i) {
				String teamName = in.readLine();
				teamId.put(teamName, i);
				teams[i] = new Team(teamName);
			}
			int G = Integer.parseInt(in.readLine());
			for (int i = 0; i < G; ++i) {
				String game = in.readLine();
				String[] parts = game.split("[#@]");
				assert (parts.length == 4);
				String team1 = parts[0];
				String team2 = parts[3];
				int g1 = Integer.parseInt(parts[1]);
				int g2 = Integer.parseInt(parts[2]);
				int id1 = teamId.get(team1);
				int id2 = teamId.get(team2);
				teams[id1].update(g1, g2);
				teams[id2].update(g2, g1);
			}
			Arrays.sort(teams);
			
			if (first) first = false;
			else out.println();
			out.println(tourName);
			for (int i = 0; i < T; ++i) {
				out.println((i + 1) + ") " + teams[i].name + " " + 
						teams[i].points + "p, " + teams[i].played + "g (" +
						teams[i].wins + "-" + teams[i].ties + "-" + teams[i].loses + "), " + 
						teams[i].diff + "gd (" + teams[i].scored + "-" + teams[i].against + ")");
			}
		}
		out.flush();
		in.close();
		System.exit(0);
	}
}
