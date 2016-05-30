package uva;

import java.util.*;
import java.io.*;

public class UVa00120_StacksofFlapjacks {
	
	static void flip(int[] arr, int i) {
		for (int l = 0, r = i; l < r; ++l, --r) {
			int t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			if (line.isEmpty()) continue;
			
 			String[] parts = line.split("[ ]+");
 			int[] arr = new int[parts.length];
 			for (int i = 0; i < parts.length; ++i)
 				arr[i] = Integer.parseInt(parts[i]);
 			
 			int[] sorted = arr.clone();
 			Arrays.sort(sorted);
			
			ArrayList<Integer> moves = new ArrayList<Integer>();
			for (int i = arr.length - 1; i >= 0; --i) {
				if (arr[i] != sorted[i]) {
					for (int j = 0; j < i; ++j)
						if (arr[j] == sorted[i]) {
							if (j != 0) {
								flip(arr, j);
								moves.add(arr.length - j);
							}
							flip(arr, i);
							moves.add(arr.length - i);
							break;
						}
				}
			}
			System.out.println(line);
			for (int m : moves)
				System.out.print(m + " ");
			System.out.println("0");
		}
		
		in.close();
		System.exit(0);
	}
}
