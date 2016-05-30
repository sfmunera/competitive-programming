import java.util.*;
import java.io.*;

public class ButtonBashing {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			int t = in.nextInt();
			
			int[] buttons = new int[n];
			for (int i = 0; i < n; ++i) {
				buttons[i] = in.nextInt();
			}
			
			int ans = 0;
			int val = t;
			boolean done = false;
			for (int c = t; c <= 3600 && !done; ++c) {
				Queue<Integer> Q = new LinkedList<Integer>();
				Set<Integer> seen = new HashSet<Integer>();
				Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
				
				Q.offer(0);
				seen.add(0);
				dist.put(0, 0);
				
				while (!Q.isEmpty()) {
					int x = Q.poll();
					int d = dist.get(x);
					if (x == c) {
						ans = d;
						val = c;
						done = true;
						break;
					}
					
					for (int i = 0; i < n; ++i) {
						int next = x + buttons[i];
						if (next < 0) next = 0;
						if (next > 3600) next = 3600;
						
						if (!seen.contains(next)) {
							seen.add(next);
							dist.put(next, d + 1);
							Q.offer(next);
						}
					}
				}
			}
			System.out.println(ans + " " + (val - t));
		}
		
		in.close();
	}
}
