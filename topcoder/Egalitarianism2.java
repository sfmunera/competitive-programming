import java.util.*;

public class Egalitarianism2 {
	public double minStdev(int[] x, int[] y) {
		double res;
		return res;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(Egalitarianism2.class, "test.*");
	}

	public void test0() {
		RETester.eq(minStdev(new int[] {0,0,1,1}, new int[] {0,1,0,1}), 0.0);
	}

	public void test1() {
		RETester.eq(minStdev(new int[] {0,0,0}, new int[] {0,9,10}), 0.5);
	}

	public void test2() {
		RETester.eq(minStdev(new int[] {12,46,81,56}, new int[] {0,45,2,67}), 6.102799971320872);
	}

	public void test3() {
		RETester.eq(minStdev(new int[] {0,0,0,0,0,0,0}, new int[] {0,2,3,9,10,15,16}), 0.9428090415820617);
	}

	public void test4() {
		RETester.eq(minStdev(new int[] {167053, 536770, -590401, 507047, 350178, -274523, -584679, -766795, -664177, 267757, -291856, -765547, 604801, -682922, -404590, 468001, 607925, 503849, -499699, -798637}, new int[] {-12396, -66098, -56843, 20270, 81510, -23294, 10423, 24007, -24343, -21587, -6318, -7396, -68622, 56304, -85680, -14890, -38373, -25477, -38240, 11736}), 40056.95946451678);
	}

	public void test5() {
		RETester.eq(minStdev(new int[] {-306880, 169480, -558404, -193925, 654444, -300247, -456420, -119436, -620920, -470018, -914272, -691256, -49418, -21054, 603373, -23656, 891691, 258986, -453793, -782940}, new int[] {-77318, -632629, -344942, -361706, 191982, 349424, 676536, 166124, 291342, -268968, 188262, -537953, -70432, 156803, 166174, 345128, 58614, -671747, 508265, 92324}), 36879.1512763429);
	}

// END CUT HERE
}
