package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 861 (920 - Sunny Mountains) */
/* SUBMISSION: 10643950 */
/* SUBMISSION TIME: 2012-09-23 20:57:49 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00920_SunnyMountains {
	
	static class Pair implements Comparable<Pair> {
		int x, y;
		
		public Pair(int x, int y) {
			this.x = x; this.y = y;
		}
		
		public int compareTo(Pair p) {
			return this.x - p.x;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			List<Pair> coords = new ArrayList<Pair>();
			
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				int x = Integer.parseInt(parts[0]);
				int y = Integer.parseInt(parts[1]);
				coords.add(new Pair(x, y));
			}
			
			Collections.sort(coords);
			
			double lasty = 0.0;
			double ans = 0.0;
			for (int i = N - 2; i >= 0; --i) {
				int x0 = coords.get(i).x;
				int y0 = coords.get(i).y;
				int x1 = coords.get(i + 1).x;
				int y1 = coords.get(i + 1).y;
				if (y0 > lasty) {
					double m = (double)(y1 - y0) / (x1 - x0);
					double b = y0 - m * x0;
					
					double yc = lasty;
					double xc = (yc - b) / m;
					
					double dx = x0 - xc;
					double dy = y0 - yc;
					ans += Math.sqrt(dx * dx + dy * dy);
					
					lasty = y0;
				}
			}
			System.out.printf(Locale.ENGLISH, "%.2f\n", ans);
		}
		
		in.close();
		System.exit(0);
	}
}
