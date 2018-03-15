package codeforces;

import java.util.*;

public class Photographer {
    
    static long a, b, d;
    
    static class Client implements Comparable<Client> {
        int id;
        long x, y;
        Client(int id, long x, long y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
        
        long cost() {
            return this.x * a + this.y * b;
        }
        
        @Override
        public int compareTo(Client that) {
            if (this.cost() < that.cost()) return -1;
            else if (this.cost() > that.cost()) return 1;
            else return 0;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        d = in.nextLong();
        a = in.nextLong();
        b = in.nextLong();
        Client[] clients = new Client[n];
        for (int i = 0; i < n; i++) {
            long x = in.nextLong();
            long y = in.nextLong();
            clients[i] = new Client(i + 1, x, y);
        }
        Arrays.sort(clients);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (d >= clients[i].cost()) {
                d -= clients[i].cost();
                ans.add(clients[i].id);
            } else {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size() + "\n");
        boolean first = true;
        for (int id : ans) {
            if (first)
                first = false;
            else
                sb.append(" ");
            sb.append(id);
        }
        System.out.println(sb);
        
        in.close();
        System.exit(0);
    }
}
