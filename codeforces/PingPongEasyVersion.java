package codeforces;

import java.util.*;

public class PingPongEasyVersion {
	
	static List<Interval> intervals;
	
	static boolean reaches(int a, int b) {
		Set<Integer> seen = new HashSet<Integer>();
		return reaches(a, b, seen);
	}
	
	static boolean reaches(int a, int b, Set<Integer> seen) {
		seen.add(a);
		if (a == b) return true;
		
		for (int i = 0; i < intervals.size(); ++i) {
			if (seen.contains(i)) continue;
			if (!intervals.get(a).canMoveTo(intervals.get(i))) continue;
			if (reaches(i, b, seen)) {
				return true;
			}
		}
		
		return false;
	}
	
	static class Interval {
		int left, right;
		Interval(int l, int r) {left = l; right = r;}
		
		boolean canMoveTo(Interval that) {
			return (this.left > that.left && this.left < that.right) ||
				   (this.right > that.left && this.right < that.right);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		intervals = new ArrayList<Interval>();
		for (int i = 0; i < n; ++i) {
			int q = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			
			if (q == 1) {
				intervals.add(new Interval(a, b));
			} else {
				--a;
				--b;
				System.out.println(reaches(a, b) ? "YES" : "NO");
			}
		}
		
		in.close();
		System.exit(0);
	}
}
