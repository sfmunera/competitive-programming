package codeforces;

import java.io.*;
import java.util.*;

public class PutKnight {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(new File("input.txt")));
		PrintWriter out = new PrintWriter(new File("output.txt"));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(in.readLine());
			
			out.println(1 - (n % 2));
		}
		
		in.close();
		out.close();
	}
}
