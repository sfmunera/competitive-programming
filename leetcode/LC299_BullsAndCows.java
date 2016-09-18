package leetcode;

public class LC299_BullsAndCows {
    int countBulls(String secret, String guess, boolean[] isBull) {
        int cntBulls = 0;
        
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++cntBulls;
                isBull[i] = true;
            }
        }
        
        return cntBulls;
    }
    
    int countCows(String secret, String guess, boolean[] isBull) {
        int cntCows = 0;
        int[] cntCow = new int[10];
        
        for (int i = 0; i < secret.length(); ++i) {
            if (isBull[i]) continue;
            int digit = secret.charAt(i) - '0';
            ++cntCow[digit];
        }
        
        for (int i = 0; i < guess.length(); ++i) {
            if (isBull[i]) continue;
            int digit = guess.charAt(i) - '0';
            if (cntCow[digit] > 0) {
                 ++cntCows;
                 --cntCow[digit];
            }
        }
        
        return cntCows;
    }
    
    public String getHint(String secret, String guess) {
        boolean[] isBull = new boolean[secret.length()];
        
        int cntBulls = countBulls(secret, guess, isBull);
        int cntCows = countCows(secret, guess, isBull);

        return cntBulls + "A" + cntCows + "B";
    }
}
