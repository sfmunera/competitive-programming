package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 417 (476 - Points in Figures: Rectangles) */
/* SUBMISSION: 09253549 */
/* SUBMISSION TIME: 2011-09-13 00:12:06 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00476_PointsinFiguresRectangles {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		
		List<Double> xul = new ArrayList<Double>();
		List<Double> yul = new ArrayList<Double>();
		List<Double> xlr = new ArrayList<Double>();
		List<Double> ylr = new ArrayList<Double>();
		while (!(line = in.readLine()).equals("*")) {
			stk = new StringTokenizer(line);
			stk.nextToken();
			xul.add(Double.parseDouble(stk.nextToken()));
			yul.add(Double.parseDouble(stk.nextToken()));
			xlr.add(Double.parseDouble(stk.nextToken()));
			ylr.add(Double.parseDouble(stk.nextToken()));
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
			for (int j = 1; j <= xul.size(); ++j) {
				if (Double.compare(x.get(i - 1), xul.get(j - 1)) > 0 &&
					Double.compare(y.get(i - 1), yul.get(j - 1)) < 0 &&
					Double.compare(x.get(i - 1), xlr.get(j - 1)) < 0 &&
					Double.compare(y.get(i - 1), ylr.get(j - 1)) > 0) {
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
