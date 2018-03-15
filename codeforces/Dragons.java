package codeforces;

import java.util.*;

public class Dragons {
    
    static class Dragon implements Comparable<Dragon> {
        int x, y;
        Dragon(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Dragon d) {
            if (this.x != d.x) return this.x - d.x;
            else return d.y - this.y;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int s = in.nextInt();
        int n = in.nextInt();
        Dragon[] dragons = new Dragon[n];
        for (int i = 0; i < n; i++) {
            dragons[i] = new Dragon(in.nextInt(), in.nextInt());
        }
        Arrays.sort(dragons);
        boolean can = true;
        for (Dragon dragon : dragons) {
            if (dragon.x >= s) {
                can = false;
            } else {
                s += dragon.y;
            }
        }
        System.out.println(can ? "YES" : "NO");
        
        in.close();
        System.exit(0);
    }
}
