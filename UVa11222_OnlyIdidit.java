package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2163 (11222 - Only I did it!) */
/* SUBMISSION: 09587332 */
/* SUBMISSION TIME: 2011-12-23 19:20:33 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa11222_OnlyIdidit {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		while ((line = in.readLine()).isEmpty());
		int T = Integer.parseInt(line.trim());
		int t = 1;
		
		while (T-- > 0) {

			while ((line = in.readLine()).isEmpty());
			String[] parts = line.trim().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int[] solved1 = new int[N];
			
			for (int i = 0; i < N; ++i)
				solved1[i] = Integer.parseInt(parts[i + 1]);
			
			while ((line = in.readLine()).isEmpty());
			parts = line.trim().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			int[] solved2 = new int[N];
			
			for (int i = 0; i < N; ++i)
				solved2[i] = Integer.parseInt(parts[i + 1]);
			
			while ((line = in.readLine()).isEmpty());
			parts = line.trim().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			int[] solved3 = new int[N];
			
			for (int i = 0; i < N; ++i)
				solved3[i] = Integer.parseInt(parts[i + 1]);
			
			Arrays.sort(solved1);
			Arrays.sort(solved2);
			Arrays.sort(solved3);
			
			List<Integer> res1 = new ArrayList<Integer>();
			List<Integer> res2 = new ArrayList<Integer>();
			List<Integer> res3 = new ArrayList<Integer>();
			
			for (int i = 0; i < solved1.length; ++i) {
				int ind1 = Arrays.binarySearch(solved2, solved1[i]);
				int ind2 = Arrays.binarySearch(solved3, solved1[i]);
				
				if (ind1 < 0 && ind2 < 0)
					res1.add(solved1[i]);
			}
			for (int i = 0; i < solved2.length; ++i) {
				int ind1 = Arrays.binarySearch(solved1, solved2[i]);
				int ind2 = Arrays.binarySearch(solved3, solved2[i]);
				
				if (ind1 < 0 && ind2 < 0)
					res2.add(solved2[i]);
			}
			for (int i = 0; i < solved3.length; ++i) {
				int ind1 = Arrays.binarySearch(solved1, solved3[i]);
				int ind2 = Arrays.binarySearch(solved2, solved3[i]);
				
				if (ind1 < 0 && ind2 < 0)
					res3.add(solved3[i]);
			}
			
			int cnt1 = res1.size();
			int cnt2 = res2.size();
			int cnt3 = res3.size();
			int max = Math.max(cnt1, Math.max(cnt2, cnt3));
			
			System.out.println("Case #" + t++ + ":");
			if (cnt1 == max) {
				System.out.print("1 " + cnt1);
				for (int x : res1)
					System.out.print(" " + x);
				System.out.println();
			}
			if (cnt2 == max) {
				System.out.print("2 " + cnt2);
				for (int x : res2)
					System.out.print(" " + x);
				System.out.println();
			}
			if (cnt3 == max) {
				System.out.print("3 " + cnt3);
				for (int x : res3)
					System.out.print(" " + x);
				System.out.println();
			}
		}
		
		in.close();
		System.exit(0);
	}
}