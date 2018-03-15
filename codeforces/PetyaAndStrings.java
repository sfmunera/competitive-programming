package codeforces;

import java.util.*;

public class PetyaAndStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String first = in.next().toLowerCase();
        String second = in.next().toLowerCase();
        int comparison = first.compareTo(second);
        if (comparison < 0) comparison = -1;
        else if (comparison > 0) comparison = 1;
        System.out.println(comparison);
        
        in.close();
        System.exit(0);
    }
}
