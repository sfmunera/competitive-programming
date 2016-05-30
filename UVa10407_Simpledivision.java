package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1348 (10407 - Simple division) */
/* SUBMISSION: 10083300 */
/* SUBMISSION TIME: 2012-05-06 23:25:33 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10407_Simpledivision {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = in.readLine().trim();
			if (line.equals("0"))
				break;
			
			String[] parts = line.split("[ ]+");
			int N = parts.length - 1;
			long[] nums = new long[N];
			
			long min = Long.MAX_VALUE;
			for (int i = 0; i < N; ++i) {
				nums[i] = Long.parseLong(parts[i]);
				min = Math.min(min, nums[i]);
			}
			for (int i = 0; i < N; ++i) {
				nums[i] -= min;
			}
			
			TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
			int cnt = 0;
			for (int i = 0; i < N; ++i) {
				if (nums[i] != 0)
					++cnt;
				for (long p = 1; p <= nums[i] / p; ++p) {
					if (nums[i] % p == 0) {
						if (!map.containsKey(p))
							map.put(p, 1);
						else {
							int val = map.get(p);
							map.put(p, val + 1);
						}
						if (p != nums[i] / p) {
							if (!map.containsKey(nums[i] / p))
								map.put(nums[i] / p, 1);
							else {
								int val = map.get(nums[i] / p);
								map.put(nums[i] / p, val + 1);
							}
						}
					}
				}
			}
			
			long max = 0;
			for (long p : map.keySet()) {
				if (map.get(p) == cnt)
					max = p;
			}
			System.out.println(max);
		}
		
		in.close();
		System.exit(0);
	}
}
