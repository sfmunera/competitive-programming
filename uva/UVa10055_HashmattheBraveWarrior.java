package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 996 (10055 - Hashmat the Brave Warrior) */
/* SUBMISSION: 09098295 */
/* SUBMISSION TIME: 2011-07-30 22:35:47 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10055_HashmattheBraveWarrior {

   public static void main(String[] args) throws IOException {

 
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

       String line;
       while((line = in.readLine()) != null)
       {

           StringTokenizer dates = new StringTokenizer(line);
           long a = Long.parseLong(dates.nextToken());
           long b = Long.parseLong(dates.nextToken());
           
           System.out.println(Math.max(a, b) - Math.min(a, b));

       }

       in.close();
       System.exit(0);

   }
   
}