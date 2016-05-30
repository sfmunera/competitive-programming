package topcoder;

import java.util.*;

public class TurnOnLamps {
	
    public int minimize(int[] roads, String initState, String isImportant) {
        long s = Long.parseLong(initState, 2);
        long t = Long.parseLong(isImportant, 2);
        int N = roads.length + 1;
        
        int[][] adj = new int[N][N];
        for (int i = 0; i < roads.length; ++i)
        	Arrays.fill(adj[i], -1);
        for (int i = 0; i < roads.length; ++i) {
        	adj[roads[i]][i + 1] = i;
        	adj[i + 1][roads[i]] = i;
        }
        Queue<Long> Q = new LinkedList<Long>();
        Map<Long, Integer> dist = new HashMap<Long, Integer>();
        Set<Long> seen = new HashSet<Long>();
        
        Q.offer(s);
        dist.put(s, 0);
        seen.add(s);
        
        while (!Q.isEmpty()) {
        	long x = Q.poll();
        	if ((x & t) == t)
        		return dist.get(x);
        	for (int i = 0; i < N; ++i)
        		for (int j = i + 1; j < N; ++j)  {        			
        			Queue<Integer> Q2 = new LinkedList<Integer>();
        			boolean[] seen2 = new boolean[N];
        			Map<Integer, Long> path = new HashMap<Integer, Long>();
        			
        			Q2.offer(i);
        			seen2[i] = true;
        			path.put(i, x);
        			while (!Q2.isEmpty()) {
        				int u = Q2.poll();
        				if (u == j)
        					break;
        				
        				long y = path.get(u);
        				for (int v = 0; v < N; ++v)
        					if (!seen2[v] && adj[u][v] >= 0) {
        						seen2[v] = true;
        						path.put(v, y ^ (1L << adj[u][v]));
        						Q2.offer(v);
        					}
        			}
        			long next = path.get(j);
    				if (!seen.contains(next)) {
    					seen.add(next);
    					dist.put(next, dist.get(x) + 1);
    					Q.offer(next);
    				}
        		}
        }
        
        return -1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TurnOnLamps.class, "test.*");
    }

	public void test0() {
		RETester.eq(minimize(new int[] {0,0,1,1}, "0001", "0111"), 1);
	}

	public void test1() {
		RETester.eq(minimize(new int[] {0,0,1,1}, "0000", "0111"), 2);
	}

	public void test2() {
		RETester.eq(minimize(new int[] {0,0,1,1,4,4}, "000100", "111111"), 2);
	}

	public void test3() {
		RETester.eq(minimize(new int[] {0,0,1,1,4,4}, "100100", "011101"), 2);
	}

	public void test4() {
		RETester.eq(minimize(new int[] {0,0,2,2,3,1,6,3,1}, "010001110", "000110100"), 1);
	}

	public void test5() {
		RETester.eq(minimize(new int[] {0,0,1,2,4,4,6,1,2,5,2,8,8,3,6,4,14,7,18,14,11,7,1,12,7,5,18,23,0,14,11,10,2,2,6,1,30,11,9,12,5,35,25,11,23,17,14,45,15}, "0000000000010000000000000010000010100000000000000", "1010111111111011011111000110111111111111111110111"), 14);
	}

// END CUT HERE
}
