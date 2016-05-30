package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 919 (978 - Lemmings Battle!) */
/* SUBMISSION: 11337998 */
/* SUBMISSION TIME: 2013-02-24 22:56:02 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00978_LemmingsBattle {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			stk = new StringTokenizer(in.readLine());
			int B = Integer.parseInt(stk.nextToken());
			int SG = Integer.parseInt(stk.nextToken());
			int SB = Integer.parseInt(stk.nextToken());
			
			PriorityQueue<Integer> green = new PriorityQueue<Integer>();
			PriorityQueue<Integer> blue = new PriorityQueue<Integer>();
			
			for (int i = 0; i < SG; ++i)
				green.offer(-Integer.parseInt(in.readLine()));
			for (int i = 0; i < SB; ++i)
				blue.offer(-Integer.parseInt(in.readLine()));
			while (!green.isEmpty() && !blue.isEmpty()) {
				int ng = green.size();
				int nb = blue.size();
				int nbattles = Math.min(B, Math.min(ng, nb));
				
				ArrayList<Integer> gwinners = new ArrayList<Integer>();
				ArrayList<Integer> bwinners = new ArrayList<Integer>();
				for (int i = 0; i < nbattles; ++i) {
					int g = -green.poll();
					int b = -blue.poll();
					
					if (g > b)
						gwinners.add(g - b);
					else if (g < b)
						bwinners.add(b - g);
				}
				
				for (int g : gwinners)
					green.offer(-g);
				for (int b : bwinners)
					blue.offer(-b);
			}
			
			StringBuilder sb = new StringBuilder();
			if (first)
				first = false;
			else
				sb.append("\n");
			
			if (green.isEmpty() && blue.isEmpty())
				sb.append("green and blue died\n");
			else if (blue.isEmpty()) {
				sb.append("green wins\n");
				while (!green.isEmpty())
					sb.append(-green.poll() + "\n");
			} else {
				sb.append("blue wins\n");
				while (!blue.isEmpty())
					sb.append(-blue.poll() + "\n");
			}
			System.out.print(sb);
		}
		
		in.close();
		System.exit(0);
	}
}
