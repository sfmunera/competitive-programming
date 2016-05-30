package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1199 (10258 - Contest Scoreboard) */
/* SUBMISSION: 08575776 */
/* SUBMISSION TIME: 2011-02-13 18:36:36 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10258_ContestScoreboard {

    static class Participant implements Comparable<Participant> {
        int num;
        int[] penalty;
        boolean[] solved;

        public Participant(int n) {
            this.num = n;
            this.penalty = new int[9];
            this.solved = new boolean[9];
        }

        public int compareTo(Participant o) {
            int nsolthis = 0;
            int nsolthat = 0;
            int penthis = 0;
            int penthat = 0;
            for (int i = 0; i < 9; ++i) {
                if (this.solved[i]) {
                    ++nsolthis;
                    penthis += this.penalty[i];
                }
                if (o.solved[i]) {
                    ++nsolthat;
                    penthat += o.penalty[i];
                }
            }
            if (nsolthis != nsolthat)
                return nsolthat - nsolthis;
            else if (penthis != penthat)
                return penthis - penthat;
            else
                return this.num - o.num;
        }

    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            int N = Integer.parseInt(in.nextLine());
            in.nextLine();
            for (int i = 0; i < N; ++i) {
                List<Participant> people = new ArrayList<Participant>();

                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.isEmpty()) break;

                    String[] parts = line.split("[ ]");
                    int num = Integer.parseInt(parts[0]);
                    int problem = Integer.parseInt(parts[1]);
                    int time = Integer.parseInt(parts[2]);
                    char status = parts[3].charAt(0);

                    int ind = -1;
                    for (int j = 0; j < people.size(); ++j)
                        if (people.get(j).num == num) {
                            ind = j;
                            break;
                        }
                    if (ind == -1) {
                        people.add(new Participant(num));
                        ind = people.size() - 1;
                    }
                    if (!people.get(ind).solved[problem - 1]) {
                        if (status == 'I')
                            people.get(ind).penalty[problem - 1] += 20;
                        else if (status == 'C') {
                            people.get(ind).penalty[problem - 1] += time;
                            people.get(ind).solved[problem - 1] = true;
                        }
                    }
                }

                Collections.sort(people);
                for (int j = 0; j < people.size(); ++j) {
                    Participant person = people.get(j);
                    int nsolved = 0;
                    int total = 0;
                    for (int k = 0; k < person.solved.length; ++k) {
                        if (person.solved[k]) {
                            ++nsolved;
                            total += person.penalty[k];
                        }
                    }
                    
                    System.out.println(person.num + " " + nsolved + " " + total);
                }
                if (i < N - 1) System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}