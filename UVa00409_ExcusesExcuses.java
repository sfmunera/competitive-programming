package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 350 (409 - Excuses, Excuses!) */
/* SUBMISSION: 08961131 */
/* SUBMISSION TIME: 2011-06-17 15:20:32 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00409_ExcusesExcuses {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (in.hasNextLine()) {
			String line = in.nextLine();
			StringTokenizer stk = new StringTokenizer(line);
			int K = Integer.parseInt(stk.nextToken());
			int E = Integer.parseInt(stk.nextToken());
			
			Set<String> keywords = new HashSet<String>();
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < K; ++i)
				keywords.add(in.nextLine());
			
			int max = 0;
			for (int i = 0; i < E; ++i) {
				String excuse = in.nextLine();
				String excuseLower = excuse.toLowerCase();
				
				int k = 0;
				int cnt = 0;
				int n = excuseLower.length();
				while (k < n) {
					while (k < n && !Character.isLetter(excuseLower.charAt(k)))
							++k;
					String word = "";
					while (k < n && Character.isLetter(excuseLower.charAt(k))) {
						word += excuseLower.charAt(k);
						++k;
					}
					if (keywords.contains(word))
						++cnt;
				}
				map.put(excuse, cnt);
				max = Math.max(max, cnt);
			}
			System.out.println("Excuse Set #" + t);
			for (String e: map.keySet()) {
				if (map.get(e) == max)
					System.out.println(e);
			}
			System.out.println();
			++t;
		}
	}
}