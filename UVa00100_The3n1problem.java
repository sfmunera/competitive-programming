package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 36 (100 - The 3n + 1 problem) */
/* SUBMISSION: 07273132 */
/* SUBMISSION TIME: 2009-07-25 23:52:13 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00100_The3n1problem
{
    static int cycleLength(int n)
    {
        int cont = 1;
        while (n != 1) {
            if (n%2 == 1)
                n = 3*n+1;
            else
                n = n/2;
            cont++;
        }

        return cont;
    }
    
    public static void main (String args[])  // entry point from OS
    {
        try {
            Scanner in = new Scanner(System.in);
            String input;
            StringTokenizer idata;
            int i, j, max;

            input = in.nextLine();
            while (!input.equals(""))
            {
              idata = new StringTokenizer (input);
              i = Integer.parseInt (idata.nextToken());
              j = Integer.parseInt (idata.nextToken());
              int a;
              int b;

              if (i < j) {
                  a = i;
                  b = j;
              } else {
                  a = j;
                  b = i;
              }
              max = 0;

              for (int k=a; k<=b; k++) {
                  int c = cycleLength(k);
                  if (c > max)
                      max = c;
              }
              System.out.println (i + " " + j + " " + max);
              input = in.nextLine();
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}