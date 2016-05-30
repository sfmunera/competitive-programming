package eafit;
import java.util.*;
import java.io.*;

public class Prase {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			String name = in.readLine();
			
			if (!map.containsKey(name))
				map.put(name, 1);
			else
				map.put(name, map.get(name) + 1);
			
			int tmp = 0;
			for (String s : map.keySet())
				if (!s.equals(name))
					tmp += map.get(s);
			
			if (map.get(name) - 1 > tmp)
				++cnt;
			
		}
		System.out.println(cnt);
		in.close();
		System.exit(0);
	}
}
