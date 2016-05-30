import java.util.*;

public class SubrectanglesOfTable {
    public long[] getQuantity(String[] table) {
    	
    	long[] res = new long[26];
    	
    	int R = table.length;
    	int C = table[0].length();
    	
    	char[][] big = new char[2 * R][2 * C];
    	for (int i = 0; i < R; ++i)
    		for (int j = 0; j < C; ++j)
    			big[i][j] = table[i].charAt(j);
    	
    	for (int i = 0; i < R; ++i)
    		for (int j = 0; j < C; ++j)
    			big[i][j + C] = big[i][j];
    	
    	for (int i = 0; i < R; ++i)
    		big[i + R] = big[i].clone();
    	
    	R *= 2;
    	C *= 2;
    		
        for (char c = 'A'; c <= 'Z'; ++c) {
        	int[][] sum = new int[R][C];
        	for (int i = 0; i < R; ++i)
        		for (int j = 0; j < C; ++j) {
        			if (big[i][j] == c)
        				sum[i][j] = 1;
        			if (i > 0) sum[i][j] += sum[i - 1][j];
        			if (j > 0) sum[i][j] += sum[i][j - 1];
        			if (i > 0 && j > 0) sum[i][j] -= sum[i - 1][j - 1];
        		}
        	
        	for (int i = 0; i < R; ++i)
        		for (int j = 0; j < C; ++j)
        			for (int k = i; k < R; ++k)
        				for (int l = j; l < C; ++l) {
        					int sub = sum[k][l];
        					if (i > 0) sub -= sum[i - 1][l];
                			if (j > 0) sub -= sum[k][j - 1];
                			if (i > 0 && j > 0) sub += sum[i - 1][j - 1];
                			res[c - 'A'] += sub;
        				}
        }
        	
        return res;
    }

}


// Powered by FileEdit
// Powered by RETester [based on ExampleBuilder]
// Powered by CodeProcessor
