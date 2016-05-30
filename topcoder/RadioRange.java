
import java.util.*;

public class RadioRange {
	
	class Point implements Comparable<Point> {
		double x;
		boolean isLeft;
		
		public Point(double x, boolean isLeft) {
			this.x = x;
			this.isLeft = isLeft;
		}
		
		@Override
		public int compareTo(Point p) {
			return Double.compare(this.x, p.x);
		}
		
		public String toString() {
			return "(" + String.format("%.3f", x) + ", " + (isLeft ? "L" : "R") + ")";
		}
		
	}
	
    public double RadiusProbability(int[] X, int[] Y, int[] R, int Z) {
        int N = X.length;

        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < N; ++i) {
        	double d = Math.sqrt((long)X[i] * X[i] + (long)Y[i] * Y[i]);
        	double l = Math.max(0.0, d - R[i]);
        	double r = d + R[i];
        	
        	points.add(new Point(l, true));
        	points.add(new Point(r, false));
        }
        
        
        Collections.sort(points);
        double sum = Math.min(points.get(0).x, Z);
        int state = 0;
        for (int i = 0; i < points.size(); ++i) {
        	if (i > 1 && state == 0 && Double.compare(points.get(i - 1).x, Z) <= 0) {
        		sum += Math.min(points.get(i).x, Z) - points.get(i - 1).x;
        	}
        	if (points.get(i).isLeft)
        		++state;
        	else
        		--state;
        }
       	sum += Math.max(Z - points.get(points.size() - 1).x, 0);
        
        return sum / Z;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(RadioRange.class, "test.*");
    }

	public void test0() {
		RETester.eq(RadiusProbability(new int[] {0}, new int[] {0}, new int[] {5}, 10), 0.5);
	}

	public void test1() {
		RETester.eq(RadiusProbability(new int[] {0}, new int[] {0}, new int[] {10}, 10), 0.0);
	}

	public void test2() {
		RETester.eq(RadiusProbability(new int[] {10}, new int[] {10}, new int[] {10}, 10), 0.4142135623730951);
	}

	public void test3() {
		RETester.eq(RadiusProbability(new int[] {11, -11, 0, 0}, new int[] {0, 0, 11, -11}, new int[] {10, 10, 10, 10}, 31), 0.3548387096774194);
	}

	public void test4() {
		RETester.eq(RadiusProbability(new int[] {100}, new int[] {100}, new int[] {1}, 10), 1.0);
	}

	public void test5() {
		RETester.eq(RadiusProbability(new int[] {1000000000}, new int[] {1000000000}, new int[] {1000000000}, 1000000000), 0.41421356237309503);
	}

	public void test6() {
		RETester.eq(RadiusProbability(new int[] {20, -20, 0, 0}, new int[] {0, 0, 20, -20}, new int[] {50, 50, 50, 50}, 100), 0.3);
	}

	public void test7() {
		RETester.eq(RadiusProbability(new int[] {0, -60, -62, -60, 63, -97}, new int[] {-72, 67, 61, -8, -32, 89}, new int[] {6, 7, 8, 7, 5, 6}, 918), 0.9407071068962471);
	}

// END CUT HERE
}
