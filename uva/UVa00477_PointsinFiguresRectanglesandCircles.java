package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 418 (477 - Points in Figures: Rectangles and Circles) */
/* SUBMISSION: 09253620 */
/* SUBMISSION TIME: 2011-09-13 00:45:28 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00477_PointsinFiguresRectanglesandCircles {
	
	static interface Figure {
		abstract boolean inside(double x, double y);
	}
	
	static class Rectangle implements Figure {
		double xul, yul, xlr, ylr;
		
		public Rectangle(double xul, double yul, double xlr, double ylr) {
			this.xul = xul;
			this.yul = yul;
			this.xlr = xlr;
			this.ylr = ylr;
		}
		
		public boolean inside(double x, double y) {
			return 	Double.compare(x, xul) > 0 &&
					Double.compare(y, yul) < 0 &&
					Double.compare(x, xlr) < 0 &&
					Double.compare(y, ylr) > 0;
		}
	}
	
	static class Circle implements Figure {
		double xc, yc, r;
		
		public Circle(double xc, double yc, double r) {
			this.xc = xc;
			this.yc = yc;
			this.r = r;
		}
		
		public boolean inside(double x, double y) {
			double dx = x - xc;
			double dy = y - yc;
			return Double.compare(dx * dx + dy * dy, r * r) < 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		List<Figure> figures = new ArrayList<Figure>();
		while (!(line = in.readLine()).equals("*")) {
			stk = new StringTokenizer(line);
			char type = stk.nextToken().charAt(0);
			
			if (type == 'r') {
				double xul = Double.parseDouble(stk.nextToken());
				double yul = Double.parseDouble(stk.nextToken());
				double xlr = Double.parseDouble(stk.nextToken());
				double ylr = Double.parseDouble(stk.nextToken());
				figures.add(new Rectangle(xul, yul, xlr, ylr));
			} else {
				double xc = Double.parseDouble(stk.nextToken());
				double yc = Double.parseDouble(stk.nextToken());
				double r = Double.parseDouble(stk.nextToken());
				figures.add(new Circle(xc, yc, r));
			}
		}
		
		List<Double> x = new ArrayList<Double>();
		List<Double> y = new ArrayList<Double>();
		while (true) {
			line = in.readLine();
			stk = new StringTokenizer(line);
			
			double xtmp = Double.parseDouble(stk.nextToken());
			double ytmp = Double.parseDouble(stk.nextToken());
			
			if (xtmp == 9999.9 && ytmp == 9999.9)
				break;
			x.add(xtmp);
			y.add(ytmp);
		}
		
		for (int i = 1; i <= x.size(); ++i) {
			boolean ok = false;
			for (int j = 1; j <= figures.size(); ++j) {
				if (figures.get(j - 1).inside(x.get(i - 1), y.get(i - 1))) {
					ok = true;
					System.out.println("Point " + i + " is contained in figure " + j);
				}
			}
			if (!ok)
				System.out.println("Point " + i + " is not contained in any figure");
		}
		
		in.close();
		System.exit(0);
	}
}
