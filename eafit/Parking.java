package eafit;
import java.util.*;
import java.io.*;

public class Parking {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts = in.readLine().split("[ ]+");
		int[] cost = new int[3];
		for (int i = 0; i < 3; ++i)
			cost[i] = Integer.parseInt(parts[i]);
		
		int[] departure = new int[3];
		int[] arrival = new int[3];
		
		for (int i = 0; i < 3; ++i) {
			parts = in.readLine().split("[ ]+");
			arrival[i] = Integer.parseInt(parts[0]);
			departure[i] = Integer.parseInt(parts[1]);
		}
		
		int[] cnt = new int[100];
		for (int i = 1; i <= 100; ++i)
			for (int j = 0; j < 3; ++j)
				if (i > arrival[j] && i <= departure[j])
					++cnt[i - 1];
		int res = 0;
		for (int i = 1; i <= 100; ++i)
			if (cnt[i - 1] > 0)
				res += cnt[i - 1] * cost[cnt[i - 1] - 1];
					
		System.out.println(res);
		
		in.close();
		System.exit(0);
	}
}
