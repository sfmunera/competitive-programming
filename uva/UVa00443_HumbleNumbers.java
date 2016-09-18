package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 384 (443 - Humble Numbers) */
/* SUBMISSION: 08897723 */
/* SUBMISSION TIME: 2011-05-28 22:08:42 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00443_HumbleNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long[] humbles = new long[5842];
		humbles[0] = 1;
	    
		TreeSet<Long> humble = new TreeSet<Long>();
	    for (int j = 1; j < 5842; ++j) {
	        humble.add(humbles[j - 1] * 2);
	        humble.add(humbles[j - 1] * 3);
	        humble.add(humbles[j - 1] * 5);
	        humble.add(humbles[j - 1] * 7);
	
	        while (!humble.isEmpty() && humble.first() <= humbles[j - 1])
	            humble.pollFirst();
	        humbles[j] = humble.first();
	    }
		
		while (true) {
			int n = in.nextInt();
			if (n == 0) break;
			
			System.out.println("The " + n + (n % 100 != 11 && n % 10 == 1 ? "st" : 
    			n % 100 != 12 && n % 10 == 2 ? "nd" : 
        			n % 100 != 13 && n % 10 == 3 ? "rd" : 
        			"th") + " humble number is " + humbles[n - 1] + ".");
		}
	}

}
