
import java.util.*;

public class PairGame {
	
	class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x; this.y = y;
		}
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		public boolean equals(Object o) {  
		    Pair p = (Pair) o;  
		    return this.hashCode() == p.hashCode();
		}
		public int hashCode() {
			return (String.valueOf(this.x) + "$" + String.valueOf(this.y)).hashCode();
		}
	}
	
    public int maxSum(int a, int b, int c, int d) {
        int ans = -1;
        HashSet<Pair> seen = new HashSet<Pair>();
        
        int x = a;
        int y = b;
        while (x > 0 && y > 0) {
        	Pair p = new Pair(x, y);
        	seen.add(p);
        	if (x > y)
        		x = x - y;
        	else if (x < y)
        		y = y - x;
        	else if (x == y)
        		break;
        }
        x = c;
        y = d;
        while (x > 0 && y > 0) {
        	Pair p = new Pair(x, y);
        	if (seen.contains(p))
        		ans = Math.max(ans, x + y);
        	if (x > y)
        		x = x - y;
        	else if (x < y)
        		y = y - x;
        	else if (x == y)
        		break;
        }
        
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PairGame.class, "test.*");
    }

	public void test0() {
		RETester.eq(maxSum(1, 2, 2, 1), 2);
	}

	public void test1() {
		RETester.eq(maxSum(15, 4, 10, 7), 7);
	}

	public void test2() {
		RETester.eq(maxSum(1, 1, 10, 10), -1);
	}

	public void test3() {
		RETester.eq(maxSum(1000, 1001, 2000, 2001), 1001);
	}

	public void test4() {
		RETester.eq(maxSum(10944, 17928, 7704, 21888), 144);
	}

	public void test5() {
		RETester.eq(maxSum(1, 1, 1, 1), 2);
	}

// END CUT HERE
}
