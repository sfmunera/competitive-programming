package eafit;

import java.io.*;

public class Kemija {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] line = in.readLine().toCharArray();
		String ans = "";
		int k = 0;
		
		while (k < line.length) {
			ans += line[k];
			
			if (line[k] == 'a' || line[k] == 'e' || line[k] == 'i' || 
					line[k] == 'o' || line[k] == 'u') {
				if (k < line.length - 2 && line[k + 1] == 'p' && line[k + 2] == line[k])
					k += 2;
			}
			++k;
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
