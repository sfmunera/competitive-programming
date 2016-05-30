package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2478 (11483 - Code Creator) */
/* SUBMISSION: 10205132 */
/* SUBMISSION TIME: 2012-06-08 19:56:51 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11483_CodeCreator {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			sb.append("Case " + t + ":\n");
			sb.append("#include<string.h>\n");
			sb.append("#include<stdio.h>\n");
			sb.append("int main()\n");
			sb.append("{\n");
			
			while (N > 0) {
				String line = in.readLine();
				if (line.isEmpty())
					continue;
				--N;
				
				line = line.replace("\\", "\\\\").replace("\"", "\\\"");
				sb.append("printf(\"");
				sb.append(line);
				sb.append("\\n\");\n");
			}
			sb.append("printf(\"\\n\");\n");
			sb.append("return 0;\n");
			sb.append("}\n");
			++t;
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
