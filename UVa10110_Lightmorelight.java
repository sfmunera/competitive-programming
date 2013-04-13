package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1051 (10110 - Light, more light) */
/* SUBMISSION: 09153429 */
/* SUBMISSION TIME: 2011-08-15 15:36:20 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10110_Lightmorelight {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            long N = Long.parseLong(in.readLine());
            if (N == 0) break;

            long sqrt = Math.round(Math.sqrt(N));
            
            System.out.println(sqrt * sqrt == N ? "yes" : "no");
        }
        in.close();
        System.exit(0);
    }
}
