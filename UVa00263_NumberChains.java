package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 199 (263 - Number Chains) */
/* SUBMISSION: 08961021 */
/* SUBMISSION TIME: 2011-06-17 14:51:04 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00263_NumberChains {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			
			System.out.println("Original number was " + n);
			Set<Integer> chain = new HashSet<Integer>();
			while (true) {
				char[] sinc = String.valueOf(n).toCharArray();
				char[] sdec = new char[sinc.length];
				Arrays.sort(sinc);
				for (int i = 0; i < sinc.length; ++i)
					sdec[sinc.length - i - 1] = sinc[i];
				int inc = Integer.parseInt(String.valueOf(sinc));
				int dec = Integer.parseInt(String.valueOf(sdec));
				int res = dec - inc;
				
				System.out.println(dec + " - " + inc + " = " + res);
				if (chain.contains(res)) {
					System.out.println("Chain length " + (chain.size() + 1));
					System.out.println();
					break;
				}
				chain.add(res);
				n = res;
			}
		}
	}
}