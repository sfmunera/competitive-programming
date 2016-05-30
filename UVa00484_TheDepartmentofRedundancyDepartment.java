package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 425 (484 - The Department of Redundancy Department) */
/* SUBMISSION: 09216420 */
/* SUBMISSION TIME: 2011-09-02 22:37:30 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00484_TheDepartmentofRedundancyDepartment {
	
	static class MutableInt {
		int value;
		
		public MutableInt(int v) {
			this.value = v;
		}
		
		public void inc() {
			++value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Long, MutableInt> map = new HashMap<Long, MutableInt>();
		List<Long> list = new ArrayList<Long>();
		
		String line;
		
		while ((line = in.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(line);
			while (stk.hasMoreTokens()) {
				long n = Long.parseLong(stk.nextToken());
				MutableInt m = map.get(n);
				if (m == null) {
					map.put(n, new MutableInt(1));
					list.add(n);
				} else
					m.inc();
			}
		}
		for (long x : list)
			System.out.println(x + " " + map.get(x).value);
		
		in.close();
		System.exit(0);
	}
}
