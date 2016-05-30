package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 513 (572 - Oil Deposits) */
/* SUBMISSION: 10777597 */
/* SUBMISSION TIME: 2012-10-22 18:08:26 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;
 
public class UVa00572_OilDeposits {
    
    static int R, C;
    static boolean[][] visited;
    static char[][] mat;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int cnt;
    
    static boolean inside(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
    
    static void dfs(int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 8; ++i) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (inside(nr, nc) && !visited[nr][nc] && mat[nr][nc] == '@')
                dfs(nr, nc);
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String[] parts = in.readLine().split("[ ]+");
            R = Integer.parseInt(parts[0]);
            C = Integer.parseInt(parts[1]);
            
            if (R == 0 && C == 0) break;
            
            mat = new char[R][C];
            visited =new boolean[R][C];
            
            for (int r = 0; r < R; ++r)
                mat[r] = in.readLine().toCharArray();
            
            cnt = 0;
            for (int r = 0; r < R; ++r)
                for (int c = 0; c < C; ++c)
                    if (!visited[r][c] && mat[r][c] == '@') {
                        ++cnt;
                        dfs(r, c);
                    }
        
            System.out.println(cnt);
        }
        
        
        in.close();
        System.exit(0);
    }
}