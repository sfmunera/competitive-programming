package codeforces;

import java.util.*;

public class CubesForMasha {
    
    static final int[][] perm2 = { {0, 1}, {1, 0} };
    static final int[][] perm3 = { {0, 1, 2}, {0, 2, 1}, {1, 0, 2},
                                   {1, 2, 0}, {2, 0, 1}, {2, 1, 0} };
    
    static boolean canMake(int x, int[][] cubes) {
        int[] digits = getDigits(x);
        if (digits.length > cubes.length) return false;
        
        for (int[] permutation : getPermutations(digits)) {
            if (match(permutation, cubes)) return true;
        }
        return false;
    }
    
    static int[] getDigits(int x) {
        int[] digits = new int[(int)Math.ceil(Math.log10(x + 0.5))];
        int index = 0;
        while (x > 0) {
            digits[index++] = x % 10;
            x /= 10;
        }
        return digits;
    }
    
    static List<int[]> getPermutations(int[] digits) {
        List<int[]> permutations = new ArrayList<>();
        if (digits.length == 1) {
            permutations.add(digits);
        } else {
            for (int[] p : (digits.length == 2 ? perm2 : perm3)) {
                int[] permutation = new int[digits.length];
                for (int i = 0; i < digits.length; i++) {
                    permutation[i] = digits[p[i]];
                }
                permutations.add(permutation);
            }
        }
        return permutations;
    }
    
    static boolean match(int[] permutation, int[][] cubes) {
        return match(permutation, cubes, 0, 0);
    }
    
    static boolean match(int[] permutation, int[][] cubes, int i, int j) {
        if (i == permutation.length) return true;
        if (i > permutation.length || j >= cubes.length) return false;
        if (i > j) return false;
        
        boolean found = false;
        for (int k = 0; k < 6; k++) {
            if (cubes[j][k] == permutation[i]) {
                found = true;
                break;
            }
        }
        return match(permutation, cubes, i, j + 1) || (found && match(permutation, cubes, i + 1, j + 1));
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[][] cubes = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                cubes[i][j] = in.nextInt();
            }
        }

        int ans = 0;
        for (int x = 1; x < 1000 && canMake(x, cubes); x++) {
            ans = x;
        }
        System.out.println(ans);
        
        in.close();
        System.exit(0);
    }
}
