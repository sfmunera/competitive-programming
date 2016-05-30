package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3590 (1149 - Bin Packing) */
/* SUBMISSION: 09282786 */
/* SUBMISSION TIME: 2011-09-21 00:41:51 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa01149_BinPacking {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			int current = Integer.parseInt(in.readLine());
			if(current==0)break;
			int[] list = new int[current];
			int size = Integer.parseInt(in.readLine());

			
			for(int i=0;i<current;i++)
				list[i]=Integer.parseInt(in.readLine());
			
			Arrays.sort(list);
			int answer =0;
			int a=0;
			int b=current-1;
			while(a<=b)
			{
				if(list[b]>size){
					b--;
					continue;
				}
				if(list[a]+list[b]<=size){
					b--;
					a++;
					answer++;
				} else {
					b--;
					answer++;
				}
				
				
			}
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(answer);
		}
		
		in.close();
		System.exit(0);
	}
}