package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 640 (699 - The Falling Leaves) */
/* SUBMISSION: 11537873 */
/* SUBMISSION TIME: 2013-03-31 16:27:54 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00699_TheFallingLeaves {
	static Map<Integer, Integer> map;
	static Scanner in;
	static boolean done;
	
	static void go(int level) {
		int key = -1;
		if (!in.hasNextInt() || (key = in.nextInt()) == -1) return;
		
		done = false;
		int val = 0;
		if (map.containsKey(level))
			val = map.get(level);
		map.put(level, key + val);
		
		go(level - 1);
		go(level + 1);
	}
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		
		int t = 1;
		while (true) {
			map = new TreeMap<Integer, Integer>();

			done = true;
			go(0);
			
			if (done) break;
			
			System.out.println("Case " + t + ":");
			boolean first = true;
			for (int val : map.values()) {
				if (first) first = false; else System.out.print(" ");
				System.out.print(val);
			}
			System.out.println("\n");
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
