package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2051 (11110 - Equidivisions) */
/* SUBMISSION: 10813593 */
/* SUBMISSION TIME: 2012-10-29 17:33:27 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11110_Equidivisions{
    
    static int N;
    static int[][] mat;
    static boolean[][] visited;
    static int[] di = {-1, 0, 0, 1};
    static int[] dj = {0, -1, 1, 0};
    
    static boolean inside(int i, int j) {
        return i >= 0 && j >= 0 && i < N && j < N;
    }
    
    static void dfs(int i, int j) {
        visited[i][j] = true;
        
        for (int d = 0; d < 4; ++d) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (inside(ni, nj) && !visited[ni][nj] && mat[i][j] == mat[ni][nj])
                dfs(ni, nj);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            N = Integer.parseInt(in.readLine());
            if (N == 0) break;
            
            mat = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 1; i < N; ++i) {
                String[] parts = in.readLine().split("[ ]+");
                for (int j = 0; j < parts.length; j += 2) {
                    int y = Integer.parseInt(parts[j]) - 1;
                    int x = Integer.parseInt(parts[j + 1]) - 1;
                    
                    mat[y][x] = i;
                }
            }
            
            int cnt = 0;
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < N; ++j)
                    if (!visited[i][j]) {
                        ++cnt;
                        dfs(i, j);
                    }
            System.out.println(cnt == N ? "good" : "wrong");
        }
        
        in.close();
        System.exit(0);
    }
}
