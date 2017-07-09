import java.io.*;
import java.util.*;

public class PearlsInARow {
	
	static class Pair {
		int l, r;
		Pair(int l, int r) {
			this.l = l;
			this.r = r;
		}
		
		public String toString() {
			return l + " " + r;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int[] a = new int[n];
		int i = 0;
		while (stk.hasMoreTokens()) {
			a[i++] = Integer.parseInt(stk.nextToken());
		}
		
		Set<Integer> seen = new HashSet<>();
		List<Pair> segments = new ArrayList<>();
		int curLeft = 0;
		boolean found = false;
		for (i = 0; i < n; i++) {
			if (seen.contains(a[i])) {
				found = true;
				segments.add(new Pair(curLeft + 1, i + 1));
				curLeft = i + 1;
				seen.clear();
			} else {
				seen.add(a[i]);
			}
		}
		
		if (curLeft < n && segments.size() > 0) {
			curLeft = segments.get(segments.size() - 1).l;
			segments.remove(segments.size() - 1);
			segments.add(new Pair(curLeft, n));
			found = true;
		}

		if (!found) {
			sb.append("-1\n");
		} else {
			sb.append(segments.size());
			sb.append("\n");
			for (Pair s : segments) {
				sb.append(s.toString());
				sb.append("\n");
			}
		}
		
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
