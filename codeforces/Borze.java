package codeforces;

import java.util.*;

public class Borze {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String code = in.nextLine();
        String ans = code.replaceAll("\\-\\-", "2");
        ans = ans.replaceAll("\\-\\.", "1");
        ans = ans.replaceAll("\\.", "0");
        System.out.println(ans);
        
        in.close();
        System.exit(0);
    }
}
