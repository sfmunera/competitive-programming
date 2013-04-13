package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 76 (140 - Bandwidth) */
/* SUBMISSION: 09204259 */
/* SUBMISSION TIME: 2011-08-30 01:20:42 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00140_Bandwidth {
	
	static void swap(char[] c, int i, int j) {
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	static boolean nextPermutation(char[] s) {
        int n = s.length;

        int k = -1;
        for (int i = n - 2; i >= 0; --i)
            if (s[i] < s[i + 1]) {
                k = i;
                break;
            }
        if (k == -1) return false;

        int l = 0;
        for (int i = n - 1; i >= 0; --i)
            if (s[k] < s[i]) {
                l = i;
                break;
            }
        swap(s, k, l);
        
        for (int i = k + 1; i < (n + k + 1) / 2; ++i) {
            swap(s, i, n + k - i);
        }
        return true;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			if (line.equals("#"))
				break;
			
			String[] vertices = line.split("[;]");
			int N = vertices.length;
			boolean[][] adj = new boolean[26][26];
			boolean[] used = new boolean[26];
			
			for (int i = 0; i < N; ++i) {
				String[] parts = vertices[i].split("[:]");
				char from = parts[0].charAt(0);
				for (char to : parts[1].toCharArray()) {
					adj[from - 'A'][to - 'A'] = adj[to - 'A'][from - 'A'] = true;
					used[from - 'A'] = used[to - 'A'] = true;
				}
			}
			String nodes = "";
			for (int i = 0; i < used.length; ++i)
				if (used[i])
					nodes += (char)(i + 'A');
			char[] cnodes = nodes.toCharArray();
			
			int min = Integer.MAX_VALUE;
			char[] selected = new char[N];
			do {
				int bandwidth = 0;
				for (int i = 0; i < cnodes.length; ++i)
					for (int j = i + 1; j < cnodes.length; ++j)
						if (adj[cnodes[i] - 'A'][cnodes[j] - 'A'])
							bandwidth = Math.max(bandwidth, j - i);
				
				if (bandwidth < min) {
					min = bandwidth;
					selected = cnodes.clone();
				}
			} while (nextPermutation(cnodes));
			
			String res = "";
			for (char c : selected)
				res += c + " ";
			res += "-> " + min;
			System.out.println(res);
		}
		
		in.close();
		System.exit(0);
	}
}
