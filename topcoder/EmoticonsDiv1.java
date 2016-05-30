
import java.util.*;

public class EmoticonsDiv1 {
	
	static final int INF = (int) (1e9);
	
	class QueueItem {
		int s, m;
		public QueueItem(int s, int m) {
			this.s = s; this.m = m;
		}
	}
	
    public int printSmiles(int smiles) {
        Queue<QueueItem> Q = new LinkedList<QueueItem>();
        int[][] cost = new int[2 * smiles + 5][2 * smiles + 5];
        for (int i = 0; i < cost.length; ++i)
        	Arrays.fill(cost[i], INF);
        
        
        Q.offer(new QueueItem(1, 0));
        cost[1][0] = 0;
        
        while (!Q.isEmpty()) {
        	QueueItem q = Q.poll();
        	int s = q.s;
        	int m = q.m;
        	
        	if (s == smiles) return cost[s][m];
        	
        	if (s + m <= 2 * smiles && cost[s + m][m] == INF) {
	        	Q.offer(new QueueItem(s + m, m));
	        	cost[s + m][m] = cost[s][m] + 1;
        	}
        	if (cost[s][s] == INF) {
	        	Q.offer(new QueueItem(s, s));
	        	cost[s][s] = cost[s][m] + 1;
        	}
        	if (s > 1 && cost[s - 1][m] == INF) {
	        	Q.offer(new QueueItem(s - 1, m));
	        	cost[s  - 1][m] = cost[s][m] + 1;
        	}
        }
        return -1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(EmoticonsDiv1.class, "test.*");
    }

	public void test0() {
		RETester.eq(printSmiles(2), 2);
	}

	public void test1() {
		RETester.eq(printSmiles(4), 4);
	}

	public void test2() {
		RETester.eq(printSmiles(6), 5);
	}

	public void test3() {
		RETester.eq(printSmiles(18), 8);
	}

	public void test4() {
		RETester.eq(printSmiles(11), 8);
	}

// END CUT HERE
}
