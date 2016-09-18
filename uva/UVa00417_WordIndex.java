package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 358 (417 - Word Index) */
/* SUBMISSION: 10097841 */
/* SUBMISSION TIME: 2012-05-10 18:56:51 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00417_WordIndex {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int k = 1;
		for (char a = 'a'; a <= 'z'; ++a)
			map.put("" + a, k++);
		for (char a = 'a'; a <= 'z'; ++a)
			for (char b = (char)(a + 1); b <= 'z'; ++b)
				map.put("" + a + b, k++);

		for (char a = 'a'; a <= 'z'; ++a)
			for (char b = (char)(a + 1); b <= 'z'; ++b)
				for (char c = (char)(b + 1); c <= 'z'; ++c)
					map.put("" + a + b + c, k++);
		
		for (char a = 'a'; a <= 'z'; ++a)
			for (char b = (char)(a + 1); b <= 'z'; ++b)
				for (char c = (char)(b + 1); c <= 'z'; ++c)
					for (char d = (char)(c + 1); d <= 'z'; ++d)
						map.put("" + a + b + c + d, k++);

		for (char a = 'a'; a <= 'z'; ++a)
			for (char b = (char)(a + 1); b <= 'z'; ++b)
				for (char c = (char)(b + 1); c <= 'z'; ++c)
					for (char d = (char)(c + 1); d <= 'z'; ++d)
						for (char e = (char)(d + 1); e <= 'z'; ++e)
							map.put("" + a + b + c + d + e, k++);

		String word;
		while ((word = in.readLine()) != null) {
			if (map.containsKey(word))
				System.out.println(map.get(word));
			else
				System.out.println(0);
		}
		
		in.close();
		System.exit(0);
	}
}