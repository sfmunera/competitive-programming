package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 54 (118 - Mutant Flatworld Explorers) */
/* SUBMISSION: 09337153 */
/* SUBMISSION TIME: 2011-10-05 17:58:25 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00118_MutantFlatworldExplorers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        char[] dirs = {'N', 'E', 'S', 'W'};
        int[] dr = {1, 0, -1, 0}; // N E S W
        int[] dc = {0, 1, 0, -1}; // N E S W
        
        String line;
        StringTokenizer stk;
        
        stk = new StringTokenizer(in.readLine());
        int C = Integer.parseInt(stk.nextToken());
        int R = Integer.parseInt(stk.nextToken());
        
        boolean[][] scent = new boolean[51][51];
        
        while ((line = in.readLine()) != null) {
            if (line.isEmpty())
                break;
            
            stk = new StringTokenizer(line);
            int c0 = Integer.parseInt(stk.nextToken());
            int r0 = Integer.parseInt(stk.nextToken());
            char ch = stk.nextToken().charAt(0);
            int dir = 0; // N
            if (ch == 'E')
                dir = 1;
            if (ch == 'S')
                dir = 2;
            if (ch == 'W')
                dir = 3;
            
            String path = in.readLine();
            
            boolean lost = false;
            for (char c : path.toCharArray()) {
                if (c == 'R')
                    dir = (dir + 1) % 4;
                if (c == 'L') {
                    --dir;
                    if (dir < 0)
                        dir = 3;
                }
                if (c == 'F') {
                    int nc = c0 + dc[dir];
                    int nr = r0 + dr[dir];
                    
                    if (nc < 0 || nr < 0 || nc > C || nr > R) {
                        if (!scent[c0][r0]) {
	                        lost = true;
	                        scent[c0][r0] = true;
	                        break;
                        }
                    } else {
	                    c0 = nc;
	                    r0 = nr;
                    }
                }
                
            }
            System.out.println(c0 + " " + r0 + " " + dirs[dir] + (lost ? " LOST" : ""));
        }
        
        in.close();
        System.exit(0);
    }
}