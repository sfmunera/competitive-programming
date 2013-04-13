package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 38 (102 - Ecological Bin Packing) */
/* SUBMISSION: 08268700 */
/* SUBMISSION TIME: 2010-09-22 03:43:52 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00102_EcologicalBinPacking {
    public static void main(String[] args)
    {
        try {
            Scanner in = new Scanner(System.in);
            String input, output;
            StringTokenizer data;
            int B[] = new int[3];
            int G[] = new int[3];
            int C[] = new int[3];
            int min, tmp;
            
            while (!(input = in.nextLine()).equals("")) {
                data = new StringTokenizer(input);
                B[0] = Integer.parseInt(data.nextToken());
                G[0] = Integer.parseInt(data.nextToken());
                C[0] = Integer.parseInt(data.nextToken());
                B[1] = Integer.parseInt(data.nextToken());
                G[1] = Integer.parseInt(data.nextToken());
                C[1] = Integer.parseInt(data.nextToken());
                B[2] = Integer.parseInt(data.nextToken());
                G[2] = Integer.parseInt(data.nextToken());
                C[2] = Integer.parseInt(data.nextToken());
                min = B[1]+B[2]+C[0]+C[2]+G[0]+G[1];
                output = "BCG";

                tmp = B[1]+B[2]+C[0]+C[1]+G[0]+G[2];
                if (tmp < min) {
                    min = tmp;
                    output = "BGC";
                }
                tmp = B[0]+B[2]+C[1]+C[2]+G[0]+G[1];
                if (tmp < min) {
                    min = tmp;
                    output = "CBG";
                }
                tmp = B[0]+B[1]+C[1]+C[2]+G[0]+G[2];
                if (tmp < min) {
                    min = tmp;
                    output = "CGB";
                }
                tmp = B[0]+B[2]+C[0]+C[1]+G[1]+G[2];
                if (tmp < min) {
                    min = tmp;
                    output = "GBC";
                }
                tmp = B[0]+B[1]+C[0]+C[2]+G[1]+G[2];
                if (tmp < min) {
                    min = tmp;
                    output = "GCB";
                }

                System.out.println(output+" "+min);
            }
        } catch(Exception e) {
            System.exit(0);
        }
    }
}