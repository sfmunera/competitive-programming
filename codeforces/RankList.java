package codeforces;

import java.util.*;

public class RankList {
	
	static class Team implements Comparable<Team> {
		int p, t;
		Team(int p, int t) {
			this.p = p;
			this.t = t;
		}
		@Override
		public int compareTo(Team that) {
			if (this.p != that.p) return that.p - this.p;
			return this.t - that.t;
		}
		@Override
		public String toString() {
			return "(" + p + ", " + t + ")";
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt() - 1;
		
		Team[] teams = new Team[n];
		
		for (int i = 0; i < n; ++i) {
			int p = in.nextInt();
			int t = in.nextInt();
			teams[i] = new Team(p, t);
		}
		
		Arrays.sort(teams);
		
		//System.out.println(Arrays.toString(teams));
		int ans = 1;
		int ind = k - 1;
		while (ind >= 0 && teams[ind].p == teams[k].p && teams[ind].t == teams[k].t) {
			--ind;
			++ans;
		}
		
		ind = k + 1;
		while (ind < n && teams[ind].p == teams[k].p && teams[ind].t == teams[k].t) {
			++ind;
			++ans;
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
