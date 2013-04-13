package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1082 (10141 - Request for Proposal) */
/* SUBMISSION: 08789294 */
/* SUBMISSION TIME: 2011-04-28 15:44:47 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10141_RequestforProposal {

    static class Proposal implements Comparable<Proposal> {

        String name;
        double compliance;
        double price;

        public Proposal(String name, double compliance, double price) {
            this.name = name;
            this.compliance = compliance;
            this.price = price;
        }

        public int compareTo(Proposal t) {
            if (this.compliance != t.compliance)
                return this.compliance - t.compliance < 0 ? 1 : -1;
            else return t.price - this.price < 0 ? 1 : -1;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cnt = 1;
        while (true) {
            String line = in.nextLine();
            StringTokenizer stk = new StringTokenizer(line);
            int n = Integer.parseInt(stk.nextToken());
            int p = Integer.parseInt(stk.nextToken());
            if (n == 0 && p == 0) break;

            if (cnt > 1) System.out.println();
            String[] reqs = new String[n];
            Proposal[] props = new Proposal[p];
            for (int i = 0; i < n; ++i)
                reqs[i] = in.nextLine();
            for (int i = 0; i < p; ++i) {
                String name = in.nextLine();
                line = in.nextLine();
                stk = new StringTokenizer(line);
                double price = Double.parseDouble(stk.nextToken());
                int r = Integer.parseInt(stk.nextToken());
                String[] met = new String[r];
                for (int j = 0; j < r; ++j)
                    met[j] = in.nextLine();
                double comp = (double)r / n;
                props[i] = new Proposal(name, comp, price);
            }

            Arrays.sort(props);
            System.out.println("RFP #" + cnt);
            System.out.println(props[0].name);
            ++cnt;
        }
    }
}
