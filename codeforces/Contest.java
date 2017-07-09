import java.util.*;

public class Contest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		
		int misha = Math.max(3 * a / 10, a - a / 250 * c);
		int vasya = Math.max(3 * b / 10, b - b / 250 * d);
		
		if (misha == vasya) {
			System.out.println("Tie");
		} else if (misha > vasya) {
			System.out.println("Misha");
		} else {
			System.out.println("Vasya");
		}
		
		in.close();
		System.exit(0);
	}
}
