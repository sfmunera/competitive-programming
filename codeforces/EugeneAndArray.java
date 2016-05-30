import java.util.*;
import java.io.*;

public class EugeneAndArray {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		int plus = 0;
		int minus = 0;
		
		stk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; ++i) {
			int a = Integer.parseInt(stk.nextToken());
			if (a == -1) {
				++minus;
			} else {
				++plus;
			}
		}

		for (int i = 0; i < m; ++i) {
			stk = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			
			int len = r - l + 1;
			sb.append((len % 2 == 0 && len / 2 <= plus && len / 2 <= minus) ? "1" : "0");
			sb.append("\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
