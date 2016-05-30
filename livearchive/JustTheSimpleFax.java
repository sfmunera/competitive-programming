package livearchive;

import java.util.*;

public class JustTheSimpleFax {
	
	static String toHexByte(int x) {
		String hex = Integer.toHexString(x).toUpperCase();
		if (hex.length() < 2)
			hex = "0" + hex;
		
		return hex;
	}
	
	static void outputRun(String[] bytes, int from, int to, StringBuilder output) {
		int length = to - from + 1;
		int offset = 3;
		
		if (length - offset <= 127) {
			if (length <= 0)
				return;

			output.append(toHexByte(length - offset + 128));
			output.append(bytes[from]);
		} else {
			outputRun(bytes, from, from + 127 + offset - 1, output);
			outputRun(bytes, from + 127 + offset, to, output);
		}
	}
	
	static void outputNonRun(String[] bytes, int from, int to, StringBuilder output) {
		int length = to - from + 1;
		int offset = 1;
		
		if (length - offset <= 127) {
			if (length <= 0)
				return;

			output.append(toHexByte(length - offset));
			for (int i = from; i <= to; ++i)
				output.append(bytes[i]);
		} else {
			outputNonRun(bytes, from, from + 127 + offset - 1, output);
			outputNonRun(bytes, from + 127 + offset, to, output);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int P = in.nextInt();
		while (P-- > 0) {
			int t = in.nextInt();
			int B = in.nextInt();
			
			StringBuilder sb = new StringBuilder();
			int cnt = 0;
			while (cnt < B) {
				String line = in.next();
				sb.append(line);
				cnt += line.length() / 2;
			}
			// assert cnt == B;
			String input = sb.toString();
			String[] bytes = new String[B + 1];
			for (int i = 0; i < input.length(); i += 2) {
				bytes[i / 2] = input.substring(i, i + 2);
			}
			bytes[B] = "";
			
			StringBuilder output = new StringBuilder();
			int lastRunEndedAt = -1;
			for (int i = 0; i < B;) {
				int runLength = 1;
				for (int j = i; j < B && bytes[j].equals(bytes[j + 1]); ++j) {
					++runLength;
				}
				if (runLength > 2) {
					outputNonRun(bytes, lastRunEndedAt + 1, i - 1, output);
					
					lastRunEndedAt = i + runLength - 1;
					outputRun(bytes, i, lastRunEndedAt, output);
					i += runLength;
				} else {
					++i;
				}
			}
			outputNonRun(bytes, lastRunEndedAt + 1, B - 1, output);
			
			String outStr = output.toString();
			System.out.println(t + " " + outStr.length() / 2);
			for (int i = 0; i < outStr.length(); i += 80) {
				System.out.println(outStr.substring(i, Math.min(outStr.length(), i + 80)));
			}
		}
		
		in.close();
		System.exit(0);
	}
}
