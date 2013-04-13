package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 39 (103 - Stacking Boxes) */
/* SUBMISSION: 10940193 */
/* SUBMISSION TIME: 2012-11-26 01:53:00 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00103_StackingBoxes {
	
	static class Box implements Comparable<Box> {
		int[] v;
		int id;
		public Box(int[] v, int id) {
			this.id = id;
			this.v = new int[v.length];
			for (int i = 0; i < v.length; ++i)
				this.v[i] = v[i];
		}
		public boolean inside(Box b) {
			for (int i = 0; i < this.v.length; ++i)
				if (this.v[i] >= b.v[i]) return false;
			return true;
		}
		public int compareTo(Box b) {
			for (int i = 0; i < this.v.length; ++i) {
				if (this.v[i] < b.v[i]) return -1;
				if (this.v[i] > b.v[i]) return 1;
			}
			return 0;
		}
		public String toString() {
			return Arrays.toString(this.v);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int k = Integer.parseInt(parts[0]);
			int n = Integer.parseInt(parts[1]);
			
			List<Box> boxes = new ArrayList<Box>();
						
			for (int i = 0; i < k; ++i) {
				parts = in.readLine().split("[ ]+");
				int[] box = new int[n];
				for (int j = 0; j < n; ++j)
					box[j] = Integer.parseInt(parts[j]);
				
				Arrays.sort(box);
				boxes.add(new Box(box, i + 1));
			}
			Collections.sort(boxes);
			int[] q = new int[k];
			int[] p = new int[k];
			Arrays.fill(p, -1);
			for (int i = 0; i < k; ++i) {
				int max = 0;
				for (int j = 0; j < i; ++j)
					if (boxes.get(j).inside(boxes.get(i)))
						if (q[j] > max) {
							max = q[j];
							p[i] = j;
						}
				q[i] = max + 1;
			}
			
			int max = 0;
			int last = -1;
			for (int i = 0; i < k; ++i) {
				if (q[i] > max) {
					max = q[i];
					last = i;
				}
			}
			System.out.println(max);
			Stack<Integer> path = new Stack<Integer>();
			while (last != -1) {
				path.push(last);
				last = p[last];
			}
			boolean first = true;
			while (!path.isEmpty()) {
				if (first)
					first = false;
				else
					System.out.print(" ");
				System.out.print(boxes.get(path.pop()).id);
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
