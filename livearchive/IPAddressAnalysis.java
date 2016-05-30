package livearchive;

import java.util.*;

public class IPAddressAnalysis {
	
	static String[] toBin(String IP) {
		String[] parts = IP.split("[\\.]");
		String[] bin = new String[parts.length];
		
		for (int i = 0; i < parts.length; ++i) {
			bin[i] = String.format("%8s", Integer.toBinaryString(Integer.parseInt(parts[i]))).replaceAll(" ", "0");
		}
		
		return bin;
	}
	
	static int getClass(String bin) {
		if (bin.startsWith("0")) {
			return 0;
		} else if (bin.startsWith("10")) {
			return 1;
		} else {
			return 2;
		}
	}
	
	static int[] solve(String[] parts, int Class) {
		int[] presu = new int[2];
		String prefix = "";
		String suffix = "";
		if (Class == 0) {
			prefix = parts[0].substring(1);
			suffix = parts[1] + parts[2] + parts[3];
		} else if (Class == 1) {
			prefix = parts[0].substring(2) + parts[1];
			suffix =  parts[2] + parts[3];
		} else {
			prefix = parts[0].substring(3) + parts[1] + parts[2];
			suffix = parts[3];
		}
		presu[0] = Integer.parseInt(prefix, 2);
		presu[1] = Integer.parseInt(suffix, 2);
		
		return presu;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextLine()) {
			String IP = in.nextLine();
			String[] bin = toBin(IP);
			int[] ans = solve(bin, getClass(bin[0]));
			
			System.out.printf("prefix =%9d  suffix =%9d\n", ans[0], ans[1]);
		}
		
		in.close();
		System.exit(0);
	}
}
