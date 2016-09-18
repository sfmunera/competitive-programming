package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2457 (11462 - Age Sort) */
/* SUBMISSION: 09142474 */
/* SUBMISSION TIME: 2011-08-12 17:39:09 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa11462_AgeSort {

    public static void main(String[] args) {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String line = in.readLine();
                int n = Integer.parseInt(line);
                if (n == 0) break;
                
                int[] freq = new int[101];
                line = in.readLine();
                StringTokenizer stk = new StringTokenizer(line);
                for (int i = 0; i < n; ++i) {
                    int num = Integer.parseInt(stk.nextToken());
                    ++freq[num];
                }
                boolean first = true;
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < 101; ++i) {
                    while (freq[i] > 0) {
                    	if (first) {
                    		first = false;
                    		res.append(i);
                    	} else
                    		res.append(" " + i);
                    	--freq[i];
                    }
                }
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}