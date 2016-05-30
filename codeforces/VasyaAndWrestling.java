package codeforces;

import java.util.*;

public class VasyaAndWrestling {
	
	static class Wrestler {
		List<Integer> sequence;
		int lastPosition;
		long sum;
		
		Wrestler() {
			sequence = new ArrayList<Integer>();
			lastPosition = -1;
			sum = 0;
		}
		
		void addTechnique(int a, int pos) {
			sequence.add(a);
			lastPosition = pos;
			sum += (long) a;
		}
		
		boolean isGreater(Wrestler that) {
			if (this.sum != that.sum) {
				return this.sum > that.sum;
			}
			int maxLen = Math.max(this.sequence.size(), that.sequence.size());
			for (int i = 0; i < maxLen; ++i) {
				if (i < this.sequence.size() && i < that.sequence.size() && this.sequence.get(i) != that.sequence.get(i))
					return this.sequence.get(i) > that.sequence.get(i);
				if (i == this.sequence.size())
					return false;
				if (i == that.sequence.size())
					return true;
			}
			
			return this.lastPosition > that.lastPosition;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		Wrestler first = new Wrestler();
		Wrestler second = new Wrestler();
		
		for (int i = 0; i < n; ++i) {
			int a = in.nextInt();
			if (a > 0) {
				first.addTechnique(a, i);
			} else {
				second.addTechnique(-a, i);
			}
		}
		
		System.out.println(first.isGreater(second) ? "first" : "second");
		in.close();
		System.exit(0);
	}
}
