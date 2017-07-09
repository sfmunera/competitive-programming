import java.util.*;

public class PashaAndStick {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int ans = 0;
		if (n % 2 == 0) {
			ans = n / 4;
			if ((n / 2) % 2 == 0) {
				ans--;
			}
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
