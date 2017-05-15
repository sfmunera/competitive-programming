import java.util.*;

public class AlienRibonucleicAcid {
    
    static final String[] PAIRS = {"SB", "BS", "CF", "FC"};
    
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
