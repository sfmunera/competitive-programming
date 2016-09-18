package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 951 (10010 - Where's Waldorf?) */
/* SUBMISSION: 08517141 */
/* SUBMISSION TIME: 2011-01-18 04:20:34 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10010_WheresWaldorf {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            int N = Integer.parseInt(in.nextLine());
            int[] dx = {1, 1,  1,  0, -1, -1, -1, 0};
            int[] dy = {1, 0, -1, -1, -1,  0,  1, 1};

            for (int caso = 0; caso < N; ++caso) {
                in.nextLine();
                String[] parts = in.nextLine().split("[ ]");
                int m = Integer.parseInt(parts[0]);
                int n = Integer.parseInt(parts[1]);

                String[] grid = new String[m];
                for (int i = 0; i < m; ++i)
                    grid[i] = in.nextLine().toLowerCase();

                int k = Integer.parseInt(in.nextLine());

                for (int i = 0; i < k; ++i) {
                    String word = in.nextLine().toLowerCase();
                    int r = 0, c = 0;

                    boolean found = true;
                    for (int y = 0; y < m; ++y) {
                        for (int x = 0; x < n; ++x) {
                            r = y;
                            c = x;
                            for (int a = 0; a < dx.length; ++a) {
                                found = true;
                                for (int b = 0; b < word.length() && found; ++b) {
                                    int xtmp = x + dx[a] * b;
                                    int ytmp = y + dy[a] * b;
                                    if (ytmp >= 0 && ytmp < m &&
                                        xtmp >= 0 && xtmp < n) {
                                            if (grid[ytmp].charAt(xtmp)
                                                != word.charAt(b))
                                                found = false;
                                    } else
                                        found = false;
                                }
                                if (found) break;
                            }
                            if (found) break;
                        }
                        if (found) break;
                    }
                    System.out.println((r + 1) + " " + (c + 1));
                }
                if (caso < N - 1) System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}