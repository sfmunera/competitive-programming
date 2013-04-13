package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1287 (10346 - Peter's Smokes) */
/* SUBMISSION: 08927623 */
/* SUBMISSION TIME: 2011-06-07 20:59:05 */
/* LANGUAGE: 2 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class UVa10346_PetersSmokes {

    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            StringTokenizer stk = new StringTokenizer(line);
            int n = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());

            System.out.println(n + (n - 1) / (k - 1));
        }
    }
}