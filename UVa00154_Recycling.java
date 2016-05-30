package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 90 (154 - Recycling) */
/* SUBMISSION: 08925170 */
/* SUBMISSION TIME: 2011-06-06 22:28:04 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00154_Recycling {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			String line = in.nextLine();
			if (line.equals("#"))
				break;
			List<String> cities = new ArrayList<String>();
			while (true) {
				if (line.charAt(0) == 'e')
					break;
				String[] parts = line.split("[,]");
				Arrays.sort(parts);
				String city = "";
				for (int i = 0; i < 5; ++i)
					city += parts[i].charAt(2);
				cities.add(city);
				line = in.nextLine();
			}
			int min = Integer.MAX_VALUE;
			int mincity = 0;
			for (int i = 0; i < cities.size(); ++i) {
				int cnt = 0;
				for (int j = 0; j < cities.size(); ++j) {
					if (i == j)
						continue;
					for (int k = 0; k < 5; ++k)
						if (cities.get(i).charAt(k) != cities.get(j).charAt(k))
							++cnt;
				}
				if (cnt < min) {
					min = cnt;
					mincity = i + 1;
				}
			}
			System.out.println(mincity);
		}
	}
}
