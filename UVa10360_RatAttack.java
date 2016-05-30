package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1301 (10360 - Rat Attack) */
/* SUBMISSION: 08962087 */
/* SUBMISSION TIME: 2011-06-17 20:01:17 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10360_RatAttack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();

        for (int i = 0; i < k; ++i) {
            int d = in.nextInt();
            int n = in.nextInt();

            long[][] map = new long[1025][1025];

            for (int j = 0; j < n; ++j) {
                int x = in.nextInt();
                int y = in.nextInt();
                int size = in.nextInt();
                for (int dy = y - d; dy <= y + d; ++dy)
                    for (int dx = x - d; dx <= x + d; ++dx)
                        if (dy >= 0 && dy < 1025 && dx >= 0 && dx < 1025)
                            map[dy][dx] += size;
            }

            long max = 0;
            int ymax = 0;
            int xmax = 0;
            for (int x = 0; x < 1025; ++x)
                for (int y = 0; y < 1025; ++y)
                    if (map[y][x] > max) {
                        max = map[y][x];
                        ymax = y;
                        xmax = x;
                    }
            System.out.println(xmax + " " + ymax + " " + max);
        }
    }
}