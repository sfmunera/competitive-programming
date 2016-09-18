package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1997 (11056 - Formula 1) */
/* SUBMISSION: 08957364 */
/* SUBMISSION TIME: 2011-06-16 14:25:32 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11056_Formula1 {
	
	static class Pilot implements Comparable<Pilot> {
		String name;
		long time;
		
		public Pilot(String name, long time) {
			this.name = name;
			this.time = time;
		}

		public int compareTo(Pilot p) {
			if (this.time < p.time)
				return -1;
			if (this.time > p.time)
				return 1;
			return this.name.toLowerCase().compareTo(p.name.toLowerCase());
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextLine()) {
			int N = Integer.parseInt(in.nextLine());
			Pilot[] pilots = new Pilot[N];
			
			for (int i = 0; i < N; ++i) {
				String entry = in.nextLine();
				StringTokenizer stk = new StringTokenizer(entry);
				String name = stk.nextToken();
				stk.nextToken();
				int min = Integer.parseInt(stk.nextToken());
				stk.nextToken();
				int sec = Integer.parseInt(stk.nextToken());
				stk.nextToken();
				int ms = Integer.parseInt(stk.nextToken());
				stk.nextToken();
				long time = 60000 * min + 1000 * sec + ms;
				pilots[i] = new Pilot(name, time);
			}
			
			Arrays.sort(pilots);
			for (int i = 0; i < pilots.length; ++i) {
				if (i % 2 == 0)
					System.out.println("Row " + (i / 2 + 1));
				System.out.println(pilots[i].name);
			}
			System.out.println();
			if (in.hasNextLine())
				in.nextLine();
		}
	}
}