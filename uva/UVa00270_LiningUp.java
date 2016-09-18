package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 206 (270 - Lining Up) */
/* SUBMISSION: 09127712 */
/* SUBMISSION TIME: 2011-08-08 18:49:13 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00270_LiningUp {

	static final double EPS = 1e-9;
	
    static class Coord implements Comparable<Coord> {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Coord t) {
            if (this.x != t.x) return this.x - t.x;
            return this.y - t.y;
        }

    }
    
    static class MutableInt {
    	int val = 2;
    	
    	public void inc() {
    		++val;
    	}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());
        in.nextLine();
        boolean first = true;
        while (T-- > 0) {
            List<Coord> pairs = new ArrayList<Coord>();

            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.isEmpty()) break;
                StringTokenizer stk = new StringTokenizer(line);
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                pairs.add(new Coord(x, y));
            }
            
            if (pairs.isEmpty())
            	break;
            Collections.sort(pairs);
            int n = pairs.size();
            
            int max = 0;
            int cnt = 0;
            int x = pairs.get(0).x;
            for (Coord c : pairs) {
            	if (c.x == x)
            		++cnt;
            	else {
            		cnt = 0;
            		x = c.x;
            	}
            	max = Math.max(max, cnt);
            }
            
            
            for (int i = 0; i < n; ++i) {
            	Map<Double, MutableInt> map = new HashMap<Double, MutableInt>();
            	Coord p1 = pairs.get(i);
            	for (int j = i + 1; j < n; ++j) {
            		Coord p2 = pairs.get(j);
            		if (p1.x == p2.x)
            			continue;
            		double m = (double)(p2.y - p1.y) / (p2.x - p1.x);
            		double b = p2.y - m * p2.x;
            		MutableInt val = map.get(m);
            		if (val == null)
            			map.put(m, new MutableInt());
            		else
            			val.inc();
            	}
            	for (MutableInt val : map.values())
                	max = Math.max(max, val.val);
            }
            
            if (first)
            	first = false;
            else
            	System.out.println();
            System.out.println(max);
        }
    }
}