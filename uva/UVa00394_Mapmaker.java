package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 330 (394 - Mapmaker) */
/* SUBMISSION: 08571942 */
/* SUBMISSION TIME: 2011-02-11 19:02:31 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00394_Mapmaker {

    static class Array {
        String name;
        int base;
        int size;
        int D;
        int[] lower;
        int[] upper;

        public Array(String n, int b, int s, int d, int[] l, int[] u) {
            this.name = n;
            this.base = b;
            this.size = s;
            this.D = d;
            this.lower = l;
            this.upper = u;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.next());
        int R = Integer.parseInt(in.next());

        Array[] arrays = new Array[N];
        for (int i = 0; i < N; ++i) {
            String n = in.next();
            int b = Integer.parseInt(in.next());
            int s = Integer.parseInt(in.next());
            int d = Integer.parseInt(in.next());
            int[] l = new int[d];
            int[] u = new int[d];
            for (int j = 0; j < d; ++j) {
                l[j] = Integer.parseInt(in.next());
                u[j] = Integer.parseInt(in.next());
            }

            arrays[i] = new Array(n, b, s, d, l, u);
        }

        for (int i = 0; i < R; ++i) {
            String name = in.next();
            int ind = 0;
            for (int j = 0; j < N; ++j) {
                if (arrays[j].name.equals(name)) {
                    ind = j;
                    break;
                }
            }
            int D = arrays[ind].D;
            int[] index = new int[D];
            int[] C = new int[D + 1];
            int ref = 0;

            for (int j = 0; j < D; ++j)
                index[j] = Integer.parseInt(in.next());

            C[D] = arrays[ind].size;
            for (int d = D - 1; d > 0; --d)
                C[d] = C[d + 1] * (arrays[ind].upper[d] -
                        arrays[ind].lower[d] + 1);
            C[0] = arrays[ind].base;
            for (int d = 1; d < D + 1; ++d)
                C[0] -= C[d] * arrays[ind].lower[d - 1];

            ref = C[0];
            for (int d = 1; d < D + 1; ++d)
                ref += C[d] * index[d - 1];

            System.out.print(name + "[");
            for (int d = 0; d < D; ++d) {
                System.out.print(index[d]);
                if (d < D - 1) System.out.print(", ");
            }
            System.out.println("] = " + ref);
        }
    }
}
