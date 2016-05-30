package livearchive;

import java.util.*;

public class VigenereCipherEncryption {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			String key = in.next();
			if (key.equals("0")) break;
			
			String text = in.next();
			
			for (int i = 0; i < text.length(); ++i) {
				int offset = key.charAt(i % key.length()) - 'A' + 1;
				char letter = (char) ((text.charAt(i) - 'A' + offset) % 26 + 'A');
				sb.append(letter);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
		in.close();
		System.exit(0);
	}
}
