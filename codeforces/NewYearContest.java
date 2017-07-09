import java.util.*;

public class NewYearContest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		Arrays.sort(a);
		int count = 0;
		int penalty = 0;
		int time = 10;
		for (int i = 0; i < n; i++) {
			if (time + a[i] <= 360) {
				count++;
			} else if (time + a[i] <= 720) {
				count++;
				penalty += time + a[i] - 360;
			} else {
				break;
			}
			time += a[i];
		}
		
		System.out.println(count + " " + penalty);
		
		in.close();
		System.exit(0);
	}
}
