import java.util.*;

public class AlienRibonucleicAcid {
    
    /*static final String[] PAIRS = {"SB", "BS", "CF", "FC"};
    
    // Time: O(N^2), Space: O(N)
    static int solve(String rnaa) {
        int ans = 0;
        while (true) {
            boolean found = false;
            for (String pair : PAIRS) {
                int index = rnaa.indexOf(pair);
                if (index >= 0) {
                    ans++;
                    found = true;
                    rnaa = rnaa.substring(0, index) + rnaa.substring(index + 2, rnaa.length());
                }
            }
            if (!found) break;
        }
        return ans;
    }*/
    
    // Time: O(N), Space: O(N)
    static int solve(String rnaa) {
        int ans = 0;
        Stack<Character> unmatched = new Stack<>();
        for (int i = 0; i < rnaa.length(); i++) {
            char base = rnaa.charAt(i);
            if (!unmatched.isEmpty() && matches(base, unmatched.peek())) {
                unmatched.pop();
                ans++;
            } else {
                unmatched.push(base);
            }
        }
        return ans;
    }
    
    static boolean matches(char first, char second) {
        String pair = "" + first + second;
        return "CFC".contains(pair) || "SBS".contains(pair);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while (in.hasNext()) {
            String rnaa = in.next();
            System.out.println(solve(rnaa));
        }
        
        in.close();
        System.exit(0);
    }
}
