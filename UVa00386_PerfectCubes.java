package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 322 (386 - Perfect Cubes) */
/* SUBMISSION: 09209080 */
/* SUBMISSION TIME: 2011-08-31 14:30:54 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00386_PerfectCubes {
	
	static class Quad implements Comparable<Quad> {
		int a, b, c, d;
		
		public Quad(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		public int compareTo(Quad t) {
			if (this.a != t.a)
				return this.a - t.a;
			if (this.b != t.b)
				return this.b - t.b;
			if (this.c != t.c)
				return this.c - t.c;
			return this.d - t.d;
		}
		
		public String toString() {
			return "Cube = " + this.a + ", Triple = (" + this.b + "," + this.c + "," + this.d + ")";
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[] cubes = new int[201];
		for (int i = 0; i < 201; ++i)
			cubes[i] = i * i * i;
		
		Set<Quad> set = new TreeSet<Quad>();
		
		for (int b = 2; b <= 200; ++b)
			for (int c = b + 1; c <= 200; ++c)
				for (int d = c + 1; d <= 200; ++d) {
					int cube = cubes[b] + cubes[c] + cubes[d];
					//System.out.println(cube);
					int a = Arrays.binarySearch(cubes, cube);
					if (a > 1) {
						Quad t = new Quad(a, b, c, d);
						set.add(t);
					}
				}
		for (Quad t : set)
			System.out.println(t);
		System.exit(0);
	}
}