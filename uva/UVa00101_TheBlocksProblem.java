package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 37 (101 - The Blocks Problem) */
/* SUBMISSION: 08268698 */
/* SUBMISSION TIME: 2010-09-22 03:40:39 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00101_TheBlocksProblem {
    static Stack pilas[];

    static void moveOnto(int a, int b, int pilaa, int pilab, int dista, int distb)
    {
        Integer e;

        regresarInicial(a, pilaa, dista);
        regresarInicial(b, pilab, distb);

        e = (Integer)pilas[pilaa].pop();
        pilas[pilab].push(e);
    }

    static void moveOver(int a, int pilaa, int pilab, int dista)
    {
        Integer e;

        regresarInicial(a, pilaa, dista);

        e = (Integer)pilas[pilaa].pop();
        pilas[pilab].push(e);
    }

    static void pileOnto(int b, int pilaa, int pilab, int dista, int distb)
    {
        Integer e;
        Stack tmp = new Stack();

        regresarInicial(b, pilab, distb);

        for (int i=1; i<=dista; i++) {
            tmp.push(pilas[pilaa].pop());
        }
        while (!tmp.empty())
            pilas[pilab].push(tmp.pop());
    }

    static void pileOver(int pilaa, int pilab, int dista)
    {
        Integer e;
        Stack tmp = new Stack();

        for (int i=1; i<=dista; i++) {
            tmp.push(pilas[pilaa].pop());
        }
        while (!tmp.empty())
            pilas[pilab].push(tmp.pop());
    }

    static void regresarInicial(int a, int pos, int dist)
    {
        Integer e;

        for (int i=1; i<dist; i++) {
            e = (Integer)pilas[pos].pop();
            pilas[e].push(e);
        }
    }

    public static void main(String[] args)
    {
        try {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String accion1, accion2;
            int par1, par2;
            StringTokenizer data;
            int n = Integer.parseInt(input);
            pilas = new Stack[n];

            for (int i=0; i<n; i++) {
                pilas[i] = new Stack();
                pilas[i].push(i);
            }

            input = in.nextLine();
            while (!input.equals("quit")) {
                data = new StringTokenizer(input);
                accion1 = data.nextToken();
                par1 = Integer.parseInt(data.nextToken());
                accion2 = data.nextToken();
                par2 = Integer.parseInt(data.nextToken());

                int pilaa=-1, pilab=-1, dista=0, distb=0;

                for (int i=0; i<n; i++) {
                    if ((dista = pilas[i].search(par1)) != -1) {
                        pilaa = i;
                        break;
                    }
                }
                for (int i=0; i<n; i++) {
                    if ((distb = pilas[i].search(par2)) != -1) {
                        pilab = i;
                        break;
                    }
                }

                if (par1 != par2 && pilaa != pilab) {
                    if (accion1.equals("move")) {
                        if (accion2.equals("onto"))
                            moveOnto(par1, par2, pilaa, pilab, dista, distb);
                        else if (accion2.equals("over"))
                            moveOver(par1, pilaa, pilab, dista);
                    } else if (accion1.equals("pile"))
                        if (accion2.equals("onto"))
                            pileOnto(par2, pilaa, pilab, dista, distb);
                        else if (accion2.equals("over"))
                            pileOver(pilaa, pilab, dista);
                }
                input = in.nextLine();
            }

            for (int i=0; i<n; i++) {
                System.out.print(i+":");
                if (!pilas[i].empty()) {
                    for (int j=0; j<pilas[i].size(); j++) {
                        System.out.print(" "+pilas[i].get(j));
                    }
                }
                System.out.println("");
            }
        } catch(Exception e) {
            System.exit(0);
        }
    }
}