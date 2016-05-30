
import java.util.*;

public class AlienAndHamburgers {
	
	class Hamburger implements Comparable<Hamburger> {
		int type, taste;
		public Hamburger(int type, int taste) {
			this.type = type;
			this.taste = taste;
		}
		@Override
		public int compareTo(Hamburger h) {
			if (this.type != h.type)
				return this.type - h.type;
			return h.taste - this.taste;
		}
	}
	
	class Type implements Comparable<Type> {
		int type, taste;
		public Type(int type, int taste) {
			this.type = type;
			this.taste = taste;
		}
		@Override
		public int compareTo(Type h) {
			if (this.taste != h.taste)
				return h.taste - this.taste;
			return this.type - h.type;
		}
		
		public String toString() {
			return "(" + this.type + ", " + this.taste + ")";
		}
	}
	
    public int getNumber(int[] type, int[] taste) {
    	int N = type.length;
        Hamburger[] hamburgers = new Hamburger[N];
        
        for (int i = 0; i < N; ++i)
        	hamburgers[i] = new Hamburger(type[i], taste[i]);
        
        Arrays.sort(hamburgers);
        
        ArrayList<Type> distinct = new ArrayList<Type>();
        int sum = 0;
        boolean lock = false;
        for (int i = 0; i < N; ++i) {
        	if (i == 0 || (i > 0 && hamburgers[i].type != hamburgers[i - 1].type)) {
        		if (i > 0)
        			distinct.add(new Type(hamburgers[i - 1].type, sum));
        		
        		sum = 0;
        		lock = false;
        		if (hamburgers[i].taste <= 0) {
        			sum = hamburgers[i].taste;
        			lock = true;
        		}
        	}
        	if (!lock && hamburgers[i].taste >= 0)
     			sum += hamburgers[i].taste;
        }
        distinct.add(new Type(hamburgers[N - 1].type, sum));
		
		int Y = 0;
		int A = 0;
		Collections.sort(distinct);
		
		for (int i = 0; i < distinct.size(); ++i) {
			if ((Y + 1) * (distinct.get(i).taste + A) > Y * A) {
				++Y;
				A += distinct.get(i).taste;
			}
		}
		
		return Y * A;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(AlienAndHamburgers.class, "test.*");
    }

	public void test0() {
		RETester.eq(getNumber(new int[] {1, 2}, new int[] {4, 7}), 22);
	}

	public void test1() {
		RETester.eq(getNumber(new int[] {1, 1}, new int[] {-1, -1}), 0);
	}

	public void test2() {
		RETester.eq(getNumber(new int[] {1, 2, 3}, new int[] {7, 4, -1}), 30);
	}

	public void test3() {
		RETester.eq(getNumber(new int[] {1, 2, 3, 2, 3, 1, 3, 2, 3, 1, 1, 1}, new int[] {1, 7, -2, 3, -4, -1, 3, 1, 3, -5, -1, 0}), 54);
	}

	public void test4() {
		RETester.eq(getNumber(new int[] {30, 20, 10}, new int[] {100000, -100000, 100000}), 400000);
	}

// END CUT HERE
}
