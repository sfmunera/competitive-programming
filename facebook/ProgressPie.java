package facebook;

import java.io.*;
import java.util.*;

public class ProgressPie {
	
	static final int RADIUS = 50;
	static final int CENTER_X = 50;
	static final int CENTER_Y = 50;
	static final double EPSILON = 1e-9;
	
	static boolean isInPie(int P, int X, int Y) {
		return isInFullCircle(X, Y) && isInAngleRange(P, X, Y);
	}
	
	static boolean isInFullCircle(int X, int Y) {
		int deltaX = X - CENTER_X;
		int deltaY = Y - CENTER_Y;
		int distance = deltaX * deltaX + deltaY * deltaY;
		
		return distance <= RADIUS * RADIUS;
	}
	
	static boolean isInAngleRange(int P, int X, int Y) {
		double pieAngle = P / 100.0 * 2.0 * Math.PI;
		double pointAngle = Math.atan2(Y - CENTER_Y, X - CENTER_X);
		if (pointAngle < -EPSILON) {
			pointAngle += 2.0 * Math.PI;
		}
		pointAngle = 2.5 * Math.PI - pointAngle;
		while (pointAngle > 2.0 * Math.PI - EPSILON) {
			pointAngle -= 2.0 * Math.PI;
		}
		
		return pointAngle <= pieAngle;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("progress_pie.txt")));
		System.setOut(new PrintStream(new File("progress_pie.out")));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int testNumber = 1; testNumber <= T; testNumber++) {
			int P = in.nextInt();
			int X = in.nextInt();
			int Y = in.nextInt();
			
			System.out.println("Case #" + testNumber + ": " + (isInPie(P, X, Y) ? "black" : "white"));
		}
		
		in.close();
		System.exit(0);
	}
}
