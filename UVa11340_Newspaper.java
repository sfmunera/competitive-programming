package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2315 (11340 - Newspaper) */
/* SUBMISSION: 09143084 */
/* SUBMISSION TIME: 2011-08-12 23:10:52 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa11340_Newspaper {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));

        int T = Integer.parseInt(in.readLine());
        
        while (T-- > 0) {
        	Map<Character, Long> prices = new HashMap<Character, Long>();
        	
            int K = Integer.parseInt(in.readLine());
            for (int k = 0; k < K; ++k) {
             	String line = in.readLine().trim();
              	StringTokenizer stk = new StringTokenizer(line);

              	prices.put(stk.nextToken().charAt(0), Long.parseLong(stk.nextToken()));
            }
            long total = 0;
            int M = Integer.parseInt(in.readLine());
            for (int k = 0; k < M; ++k) {
                String line = in.readLine();
                
                for (char c : line.toCharArray())
                	if (prices.containsKey(c))
                		total += prices.get(c);
            }
            System.out.printf(Locale.ENGLISH, "%.2f$%n", (double)total / 100.0);
        }
        in.close();
        System.exit(0);

    }
}