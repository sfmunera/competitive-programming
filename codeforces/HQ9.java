package codeforces;

import java.util.*;

public class HQ9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String program = in.next();
        boolean ok = program.contains("H") || program.contains("Q") || program.contains("9");
        System.out.println(ok ? "YES" : "NO");
        
        in.close();
        System.exit(0);
    }
}
